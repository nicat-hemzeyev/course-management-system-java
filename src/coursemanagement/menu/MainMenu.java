package coursemanagement.menu;

import java.util.Scanner;

public class MainMenu {
    public static void mainMenu(){
        System.out.println(
                "---ƏSAS MENU---\n" +
                "Seçiminizi edin:\n"+
                "1.Kurs menyusu\n"+
                "2.Müəllim menyusu\n"+
                "3.Tələbə menyusu\n"+
                "0.Çıxış"
        );
        int emeliyyat =new Scanner(System.in).nextInt();
        switch (emeliyyat){
            case 0:
                System.exit(0);
                break;
            case 1:
                CourseMenu.courseMenu();
                break;
            case 2:
                TeacherMenu.teacherMenu();
                break;
            case 3:
              StudentMenu.studentMenu();
                break;
            default:
                System.out.println("Seçim yanlışdır");

        }

    }
}