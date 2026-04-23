package coursemanagement.menu;

import coursemanagement.course.service.CourseService;

import java.util.Scanner;

public class CourseMenu {
    public static void courseMenu() {
        CourseService service=new CourseService();
        while (true) {

            System.out.println("------KURS MENU------\n" +
                    "Edeceyiniz emeliyyati secin:\n" +
                    "1.Kurs elave et\n" +
                    "2.Kurslari goster\n" +
                    "3.Kursu yenile\n" +
                    "4.Kursu sil\n" +
                    "5.Muellimi kursa teyin et\n" +
                    "6.Telebeni kursa teyin et\n" +
                    "0.Geri don"
            );
            int emeliyyat = new Scanner(System.in).nextInt();
            switch (emeliyyat) {
                case 0:
                    MainMenu.mainMenu();
                    break;
                case 1:
                    service.addCourse();
                    break;
                case 2:
                  service.listCourse();
                    break;
                case 3:
                    service.updateCourse();
                    break;
                case 4:
                    service.deleteCourse();
                    break;
                case 5:
                   service.addTeacherToCourse();
                    break;
                case 6:
                  service.addStudentToCourse();
                    break;
                default:
                    System.out.println("Seçim yanlışdır");
            }

        }
    }
}