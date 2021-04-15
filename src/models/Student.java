package models;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String firstName, lastName;
    private LocalDate birthday;

    public Student(String firstName, String lastName, LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
        if (firstName.matches("[A-Z][a-z]*"))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("Names must start with an upper case letter and only contain alphabetic characters");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
        if (lastName.matches("[A-Z][a-z]*"))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("must be alphabetic & not contain spaces or -");
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("birthday cannot be in the future");
        this.birthday = birthday;
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
