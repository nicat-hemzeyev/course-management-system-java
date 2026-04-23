package coursemanagement.course.service;

import coursemanagement.course.entity.Course;
import coursemanagement.dao.CourseDAO;
import coursemanagement.student.service.StudentService;
import coursemanagement.teacher.service.TeacherService;

import java.util.List;
import java.util.Scanner;

public class CourseService {
    CourseDAO courseDAO = new CourseDAO();
    private TeacherService teacherService = new TeacherService();
    private StudentService studentService =new StudentService();

    public void addCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kursun adini daxil edin:");
        String name = sc.nextLine();
        Course course = new Course(name);
        courseDAO.addCourse(course);
    }

    public void listCourse() {
        List<Course> courses = courseDAO.listCourse();
        for (Course c : courses) {
            System.out.println(c.getCourseID() + " " + c.getCourseName());
        }

    }

    public void updateCourse() {
        Scanner sc = new Scanner(System.in);
        listCourse();
        System.out.println("Hansi ID-li kursu yenilemek isteyirsiz?");
        int id = sc.nextInt();
        sc.nextLine();
        Course existing = courseDAO.findById(id);
        if (existing == null) {
            System.out.println("Bu ID-li kurs yoxdur!");
            return;
        }
        System.out.println("Kursun yeni adını daxil edin:");
        existing.setCourseName(sc.nextLine());
        courseDAO.updateCourse(existing);

    }

    public void deleteCourse() {
        listCourse();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hansı ID-li kursu silmək istəyirsiz?");
        int id = sc.nextInt();
        courseDAO.deleteCourse(id);
        System.out.println("Kurs uğurla silindi!");

    }

    public void addTeacherToCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Müəllim əlavə etmək istədiyiniz kursu seçin:");
        listCourse();
        int courseNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Müəllimlərin siyahısı:");
        teacherService.listTeacher();
        System.out.println("Kursa hansı ID-li müəllimi əlavə etmək istəyirsiniz?");
        int teacherNumber = sc.nextInt();
        sc.nextLine();
        courseDAO.addTeacherToCourse(courseNumber, teacherNumber);
    }

    public void addStudentToCourse() {
        Scanner sc = new Scanner(System.in);
        listCourse();
        System.out.println("Neçə nömrəli kursa tələbə əlavə etmək istəyirsiz?");
        int courseNumber = sc.nextInt();
        sc.nextLine();
        studentService.listStudent();
        System.out.println("Kursa hansı ID-li tələbəni əlavə etmək istəyirsiz?");
        int studentNumber = sc.nextInt();
        sc.nextLine();
        courseDAO.addStudentToCourse(courseNumber, studentNumber);

    }

}