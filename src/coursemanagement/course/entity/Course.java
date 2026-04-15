package coursemanagement.course.entity;
import coursemanagement.student.entity.Student;
import coursemanagement.teacher.entity.Teacher;

import java.util.Arrays;

public class Course {
    int courseID;
    String courseName;
    Teacher teacher;
    Student[] students;
    private Student[] students1;//telebeler ucun massiv
    private int studentCount; //neche telebe elave olunub

    public Course(int capacity) {
        students1 = new Student[capacity]; //kursa neche nefer telebe qebul edile biler
        studentCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students1.length) {
            students1[studentCount] = student;
            studentCount++;
            System.out.println("Telebe kursa elave olundu:");
        } else {
            System.out.println("Kurs doludur telebe elave etmek olmur!");
        }
    }
    public void listStudent(){
        for(int i=0;i<studentCount;i++){
            System.out.println(students1[i]);
        }
    }

    public Course(String courseName, int courseId) {
        this.courseName = courseName;
        this.courseID = courseId;

    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
