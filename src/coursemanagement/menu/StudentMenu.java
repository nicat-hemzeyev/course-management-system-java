package coursemanagement.menu;

import coursemanagement.student.service.StudentService;

import java.util.Scanner;

public class StudentMenu {
    public static void studentMenu() {
        StudentService service =new StudentService();
        while (true) {
            System.out.println(
                    "------ TELEBE MENU ------\n" +
                            "Edeceyiniz emeliyyati secin:\n" +
                            "1.Telebe elave et\n" +
                            "2.Telebeleri goster\n" +
                            "3.Telebeni yenile\n" +
                            "4.Telebeni sil\n" +
                            "0.Geri don"
            );
            int emeliyyat = new Scanner(System.in).nextInt();
            switch (emeliyyat) {
                case 0:
                    MainMenu.mainMenu();
                    break;
                case 1:
                    service.addStudent();
                    break;
                case 2:
                    service.listStudent();
                    break;
                case 3:
                    service.updateStudent();
                    break;
                case 4:
                    service.deleteStudent();
                    break;
                default:
                    System.out.println("Seçim yanlışdır");

            }
        }
    }
}