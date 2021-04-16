package models;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String firstName, lastName;
    private LocalDate birthday;
    private int studentNum;

    public Student(String firstName, String lastName, LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        if(firstName.length()>=2){
            firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
            if (firstName.matches("[A-Z][a-z]*"))
                this.firstName = firstName;
            else
                throw new IllegalArgumentException("First name must start with an upper case letter and only contain alphabetic characters");
        }
        else
            throw new IllegalArgumentException("First name must have at least 2 characters");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName.trim();
        if(lastName.length()>=2){
            lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
            if (lastName.matches("[A-Z][a-z]*"))
                this.lastName = lastName;
            else
                throw new IllegalArgumentException("Last name must start with an upper case letter and only contain alphabetic characters");
        }
        else
            throw new IllegalArgumentException("Last name must have at least 2 characters");
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if(birthday != null) {
            if (birthday.isAfter(LocalDate.now()))
                throw new IllegalArgumentException("birthday cannot be in the future");
            this.birthday = birthday;
        }
        else
            throw new IllegalArgumentException("Select your date of birth");
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        if (studentNum>=100000000)
            this.studentNum = studentNum;
        else
            throw new IllegalArgumentException("student number must be greater than 100000000");
    }

    /**
     * This returns the Student's age in years based on their birthday and the current date
     * @return
     */
    public int getAge()
    {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public String toString()
    {
        return String.format("Name : %s %s \nage: %d years", firstName, lastName, getAge());
    }
}
