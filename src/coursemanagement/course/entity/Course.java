package coursemanagement.course.entity;
import coursemanagement.student.entity.Student;
import coursemanagement.teacher.entity.Teacher;

import java.util.Arrays;

public class Course {
    int courseID;
    String courseName;
    Teacher teacher;
    Student[] students;

    public Course() {

    }

    public Course(String name) {
        this.courseName = name;
    }

    public int getCourseID() {
        return courseID;
    }

    public Course setCourseID(int courseID) {
        this.courseID = courseID;
        return this; //metod chaining
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + courseID +
                ", Name=" + courseName +
                ", teacher=" + teacher +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
