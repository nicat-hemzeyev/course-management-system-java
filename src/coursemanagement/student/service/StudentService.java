package coursemanagement.student.service;

import coursemanagement.dao.StudentDAO;
import coursemanagement.student.entity.Student;

import java.util.List;
import java.util.Scanner;

public class StudentService {
    StudentDAO studentDAO = new StudentDAO();

    public void addStudent() {
        System.out.println("Nece telebe qeydiyyatdan kecirmek isteyirsiz: ");
        int number = new Scanner(System.in).nextInt();
        Student[] newStudents = new Student[number];
        for (int i = 0; i < newStudents.length; i++) {
            System.out.println("qeydiyyat " + (i + 1) + ".");
            newStudents[i] = requireAndCreate();
            studentDAO.addStudent(newStudents[i]);
        }
    }

    public void listStudent() {
        List<Student> students = studentDAO.listStudent();
        for (Student s : students) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getSurname() + " " + s.getAge());
        }
    }

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        List<Student> students = studentDAO.listStudent();
        if (students == null)
            System.out.println("Mövcud tələbə yoxdur!");
        for (Student s : students) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getSurname() + " " + s.getAge());
        }

        System.out.println("Hansı ID-li tələbəni yeniləmək istəyirsiniz?");
        int id = sc.nextInt();
        sc.nextLine();
        Student existing = studentDAO.findById(id);
        if (existing == null) {
            System.out.println("Bu ID-li tələbə yoxdur!");
            return;
        }
        System.out.println("Hansı məlumatı yeniləmək istəyirsiniz? (name, surname, age, email)");
        String field = sc.nextLine();
        switch (field) {
            case "name":
                System.out.println("Yeni adı daxil edin:");
                existing.setName(sc.nextLine());
                break;
            case "surname":
                System.out.println("Yeni soyadı daxil edin:");
                existing.setSurname(sc.nextLine());
                break;
            case "age":
                System.out.println("Yeni yaşı daxil edin:");
                existing.setAge(sc.nextInt());
                sc.nextLine();
                break;
            case "email":
                System.out.println("Yeni emaili daxil edin:");
                existing.setEmail(sc.nextLine());
                break;
            default:
                System.out.println("Yanlış seçim");
                return;
        }
        studentDAO.updateStudent(existing);
    }

    public void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hansı ID-li telebeni silmek isteyirsiz?");
        List<Student> students = studentDAO.listStudent();
        if (students == null) {
            System.out.println("Mövcud tələbə yoxdur!");
            return;
        }
        for (Student s : students) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getSurname() + " " + s.getAge());
        }
        int id = sc.nextInt();
        studentDAO.deleteStudent(id);
        System.out.println("Tələbə silindi!");


    }

    public Student requireAndCreate() {
        System.out.println("Telebenin adini daxil edin: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Telebenin soyadini daxil edin: ");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("Telebenin yasini daxil edin: ");
        int age = new Scanner(System.in).nextInt();
        System.out.println("Telebenin emailini daxil edin: ");
        String email = new Scanner(System.in).nextLine();
        return new Student(name, surname, age, email);

    }
}
