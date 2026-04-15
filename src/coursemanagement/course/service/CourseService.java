package coursemanagement.course.service;
import coursemanagement.commond.Db;
import coursemanagement.course.entity.Course;
import coursemanagement.student.entity.Student;
import coursemanagement.student.service.StudentService;
import coursemanagement.teacher.entity.Teacher;

import java.util.Scanner;

public class CourseService {
    public static void addCourse(){
        System.out.println("neche dene kurs elave edeceksiniz:");
        int count = new Scanner(System.in).nextInt();
        Course[] course = new Course[count];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            int Id = i + 1;
            System.out.println("Kursun adini daxil edin:");
            String name = sc.nextLine();
            Course course1 = new Course(name, Id);
            course[i] = course1;
        }
        Db.courses = course;

    }
    public static void listCourse(){
        Course[] course = Db.courses;
        System.out.println("Sizin kurslariniz:");
        for (int i = 0; i < course.length; i++) {
            if (course[i] == null) continue;
            System.out.println((i + 1) + ". " + course[i]);
        }

    }
    public static void addStudentToCourse(){
        Scanner sc = new Scanner(System.in);
        StudentService.printAll();
        System.out.println("Hansi telebeni kursa elave etmek isteyirsiz?");
        int studentNumber = sc.nextInt();
        sc.nextLine();
        listCourse();
        System.out.println("Hansi kursa elave etmek isteyirsiz?");
        int courseNumber = sc.nextInt();
        sc.nextLine();
        Student student = Db.students[studentNumber - 1];
        Course course = Db.courses[courseNumber - 1];
        course.addStudent(student);



    }
    public static void assignTeacherToCourse(){
        System.out.println("Muellimlerin siyahisi:");
        Teacher[] teacher = Db.teachers;
        for (int i = 0; i < teacher.length; i++) {
            if (teacher[i] != null)
                System.out.println((i + 1) + ". " + teacher[i]);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Hansi nomreli muellimi isteyirsiz?");
        int teacherNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Hansi kursu isteyirsiz?");
        listCourse();
        int courseNumber = sc.nextInt();
        sc.nextLine();
        Teacher teacher1 = Db.teachers[teacherNumber - 1];
        Course course = Db.courses[courseNumber - 1];
        course.setTeacher(teacher1);
        System.out.println("Muellim kursa elave olundu");

    }
    public static void removeCourse(){
        Course[] course = Db.courses;
        System.out.println("Hansi kursu silmek isteyirsiz?");
        int removeCourse = new Scanner(System.in).nextInt();
        if (course[removeCourse - 1] == null) {
            System.out.println("Kurs movcud deyil!");
        } else {
            course[removeCourse - 1] = null;
            System.out.println("Kurs silindi.");
        }
    }
}
