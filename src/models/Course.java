package models;

public class Course {
    private String courseName;
    private int crn;

    public Course(String courseName, int crn) {
        setCourseName(courseName);
        setCrn(crn);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        courseName = courseName.substring(0,1).toUpperCase() + courseName.substring(1);
        if (courseName.matches("[A-Z][a-z]*"))
            this.courseName = courseName;
        else
            throw new IllegalArgumentException("Names must start with an upper case letter and only contain alphabetic characters");
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        if (crn >= 1000 && crn <= 3000)
            this.crn = crn;
        else
            throw new IllegalArgumentException("crn must be between 1000 - 3000");
    }

    public String toString()
    {
        return "Name : " + getCourseName() + "\nCRN : " + getCrn();
    }
}
