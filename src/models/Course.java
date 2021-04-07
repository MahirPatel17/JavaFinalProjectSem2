package models;

public class Course {
    private String courseName, courseType;
    private int courseCode;

    public Course(String courseName, String courseType, int courseCode) {
        setCourseName(courseName);
        setCourseType(courseType);
        setCourseCode(courseCode);
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

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        courseType = courseType.substring(0,1).toUpperCase() + courseType.substring(1);
        if (courseType.matches("[A-Z][a-z]*"))
            this.courseType = courseType;
        else
            throw new IllegalArgumentException("Names must start with an upper case letter and only contain alphabetic characters");
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode >= 1000)
            this.courseCode = courseCode;
        else
            throw new IllegalArgumentException("student number must be greater than 1000");
    }
}
