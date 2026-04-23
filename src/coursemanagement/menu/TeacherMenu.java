package coursemanagement.menu;

import coursemanagement.teacher.service.TeacherService;

import java.util.Scanner;

public class TeacherMenu {
    public static void teacherMenu() {
        TeacherService teacherService =new TeacherService();
        while (true) {
            System.out.println("------MÜƏLLIM MENU------\n" +
                    "Edəcəyiniz əməliyyatı seçin:\n" +
                    "1.Müəllim əlavə et\n" +
                    "2.Müəllimləri göstər\n" +
                    "3.Müəllimi yenilə\n"+
                    "4.Müəllimi sil\n" +
                    "0.Geri dön\n"
            );
            int emeliyyat = new Scanner(System.in).nextInt();
            switch (emeliyyat) {
                case 0:
                    MainMenu.mainMenu();
                    break;
                case 1:
                    teacherService.addTeacher();
                    break;
                case 2:
                   teacherService.listTeacher();
                    break;
                case 3:
                    teacherService.updateTeacher();
                    break;
                case 4:
                    teacherService.deleteTeacher();
                    break;
                default:
                    System.out.println("Seçim yanlışdır");
            }

        }
    }
}
