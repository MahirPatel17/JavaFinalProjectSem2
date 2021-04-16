package utilities;

import models.Student;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "root";
    private static String password = "";
    private static String connString = "jdbc:mysql://localhost:3306/java_project";

    public static ArrayList<Student> getStudentsFromDB() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();

        //connect to the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //connect to the Database
            conn = DriverManager.getConnection(connString, user, password);

            statement = conn.createStatement();

            //run the query on the DB
            resultSet = statement.executeQuery("SELECT * FROM students");

            //loop over the resultset and create Student objects
            while (resultSet.next()){
                Student newStudent = new Student(resultSet.getString("firstName"),
                                                 resultSet.getString("lastName"),
                                                 resultSet.getDate("birthday").toLocalDate());
                students.add(newStudent);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }
        return students;
    }

    public static int getEnrolledIntoDB(Student newStudent) throws SQLException {
        int studentNum = -1;

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the DB
            conn = DriverManager.getConnection(connString,user,password);

            //2. create our sql statement
            statement = conn.prepareStatement("INSERT INTO students (firstName, lastName, birthday) VALUES " +
                    "(?,?,?)", new String[]{"studentNum"});

            //3. bind the values to the datatypes
            statement.setString(1, newStudent.getFirstName());
            statement.setString(2, newStudent.getLastName());
            statement.setDate(3, Date.valueOf(newStudent.getBirthday()));

            //4. execute the insert
            statement.executeUpdate();

            //5. get the student number returned
            resultSet = statement.getGeneratedKeys();

            //6. update the student number variable
            while (resultSet.next())
                studentNum = resultSet.getInt(1);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
            return studentNum;
        }
    }
}
