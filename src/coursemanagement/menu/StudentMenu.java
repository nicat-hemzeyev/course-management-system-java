package coursemanagement.menu;

import coursemanagement.student.service.StudentService;

import java.util.Scanner;

public class StudentMenu {

    public static void studentMenu() {
        System.out.println("Edeceyiniz emeliyyati secin");
        System.out.println(" ------ STUDENT MENU ------\n" +
                "     1.ilkin qeydiyyat\n" +
                "     2.yenisini elave etmek\n" +
                "     3.yenilemek(update)\n" +
                "     4.silmek\n" +
                "     5.axtarmaq\n" +
                "     6.hamisini gormek");
        int emeliyyat = new Scanner(System.in).nextInt();
        switch (emeliyyat) {
            case 1:
                StudentService.newStudent();
                break;
            case 2:
                StudentService.newAddStudent();
                break;
            case 3:
                StudentService.update();
                break;
            case 4:
                StudentService.delete();
                break;
            case 5:
                StudentService.find();
                break;
            case 6:
                StudentService.printAll();
                break;
            default:
                System.out.println("Sechim yanlisdir");

        }
    }
}
