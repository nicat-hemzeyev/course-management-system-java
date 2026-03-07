package coursemanagement.course.entity;
import coursemanagement.student.entity.Student;
import coursemanagement.teacher.entity.Teacher;

public class Course {
    String courseID;
    String courseName;
    Teacher teacher; //niye arrayiz
    Student[] students;//niye arrayli yazilir
    public String getCourseID() {
        return courseID;
    }

    public Course setCourseID(String courseID) {
        this.courseID = courseID;
        return this; //metod chaining
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
