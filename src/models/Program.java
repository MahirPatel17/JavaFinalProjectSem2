package models;

public class Program {
    private String programName, programType;
    private int programCode;

    public Program(String programName, String programType, int programCode) {
        setProgramName(programName);
        setProgramType(programType);
        setProgramCode(programCode);
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        programName = programName.substring(0,1).toUpperCase() + programName.substring(1);
        if (programName.matches("[A-Z][a-z]*"))
            this.programName = programName;
        else
            throw new IllegalArgumentException("Names must start with an upper case letter and only contain alphabetic characters");
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        programType = programType.substring(0,1).toUpperCase() + programType.substring(1);
        if (programType.matches("[A-Z][a-z]*"))
            this.programType = programType;
        else
            throw new IllegalArgumentException("Names must start with an upper case letter and only contain alphabetic characters");
    }

    public int getProgramCode() {
        return programCode;
    }

    public void setProgramCode(int programCode) {
        if (programCode >= 1 && programCode <= 100)
            this.programCode = programCode;
        else
            throw new IllegalArgumentException("programCode must be between 1 - 100");
    }
}
