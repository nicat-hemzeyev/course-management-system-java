package coursemanagement.teacher.service;

import coursemanagement.dao.TeacherDAO;
import coursemanagement.teacher.entity.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherService {
    private TeacherDAO teacherDAO = new TeacherDAO();

    public void addTeacher() {
        System.out.println("Neçə nəfər müəllim əlavə edəcəksiz?");
        int count = new Scanner(System.in).nextInt();
        Teacher[] teachers=new Teacher[count];
        Scanner sc =new Scanner(System.in);
        for(int i=0;i<count;i++){
            System.out.print((i+1)+". ");
            System.out.println("Müəllimin adını daxil edin:");
            String name =sc.nextLine();
            System.out.println("Müəllimin soyadını daxil edin:");
            String surName = sc.nextLine();
            System.out.println("Müəllimin yaşını daxil edin:");
            byte age = sc.nextByte(); sc.nextLine();
            System.out.println("Müəllimin emailini daxil edin:");
            String eMail =sc.nextLine();
            System.out.println("Müəllimin maaşını daxil edin:");
            int salary = sc.nextInt();
            sc.nextLine();
            Teacher teacher =new Teacher(name,surName,age,eMail,salary);
            teachers[i]=teacher;
            teacherDAO.addTeacher(teacher);
        }
    }

    public void listTeacher() {
        List<Teacher> teachers = teacherDAO.listTeachers();
        for (Teacher t : teachers) {
            System.out.println(t.getId() + "." + t.getName() + " " + t.getSurname() + " " + t.getAge());
        }
    }

    public void updateTeacher() {

        Scanner sc = new Scanner(System.in);

        // 1. Mövcud müəllimləri göstər
        List<Teacher> teachers = teacherDAO.listTeachers();
        if (teachers == null || teachers.isEmpty()) {
            System.out.println("Hazırda müəllim yoxdur.");
            return;
        }
        for (Teacher t : teachers) {
            System.out.println(t.getId() + " | " + t.getName() + " " + t.getSurname());
        }

        // 2. İstifadəçidən ID soruş
        System.out.println("Hansı ID-li müəllimi yeniləmək istəyirsiniz?");
        int id = sc.nextInt();
        sc.nextLine();

        Teacher existing = teacherDAO.findById(id);
        if (existing == null) {
            System.out.println("Bu ID-li müəllim yoxdur!");
            return;
        }

        // 3. Hansı sahəni yeniləmək istədiyini soruş
        System.out.println("Hansı məlumatı yeniləmək istəyirsiniz? (name, surname, age, email, salary)");
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
                System.out.println("Yeni email daxil edin:");
                existing.setEmail(sc.nextLine());
                break;
            case "salary":
                System.out.println("Yeni maaşı daxil edin:");
                existing.setSalary(sc.nextInt());
                sc.nextLine();
                break;
            default:
                System.out.println("Yanlış seçim!");
                return;
        }

        // 4. DAO-ya göndər
        teacherDAO.updateTeacher(existing);
    }

    public void deleteTeacher() {
        listTeacher();
        System.out.println("Neçə nömrəli müəllimi silmək istəyirsiz?");
        int number=new Scanner(System.in).nextInt();
        teacherDAO.deleteTeacher(number);
        System.out.println("Müəllim silindi!");


    }
}
