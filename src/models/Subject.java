package models;

public class Subject {

    private String subjectName, gradeType;
    private int crn;

    public Subject(String subjectName, int crn, String gradeType) {
        setSubjectName(subjectName);
        setCrn(crn);
        setGradeType(gradeType);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        subjectName = subjectName.substring(0,1).toUpperCase() + subjectName.substring(1);
        if (subjectName.matches("[A-Z][a-z]*"))
            this.subjectName = subjectName;
        else
            throw new IllegalArgumentException("Names must start with an upper case letter and only contain alphabetic characters");
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        if (crn >= 10000 && crn <= 30000)
            this.crn = crn;
        else
            throw new IllegalArgumentException("student number must be between 10000 - 30000");
    }

    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        gradeType = gradeType.substring(0,1).toUpperCase() + gradeType.substring(1);
        if (gradeType.matches("[A-Z][a-z]*"))
            this.gradeType = gradeType;
        else
            throw new IllegalArgumentException("Names must start with an upper case letter and only contain alphabetic characters");    }
}
