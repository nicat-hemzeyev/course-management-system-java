package coursemanagement.student.entity;

import coursemanagement.commond.User;

public class Student extends User {
    private char grade;

    String getRole() {
        return "STUDENT";
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

}
