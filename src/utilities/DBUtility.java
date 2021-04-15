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
}
