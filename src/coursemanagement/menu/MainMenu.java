package coursemanagement.menu;

import java.util.Scanner;

public class MainMenu {
    public static void mainMenu(){
        System.out.println(
                "     ESAS SEHIFE\n"+
                "---------------------\n"+
                "Seciminizi edin:\n"+
                "1.Kurs menusu\n"+
                "2.Muellim menusu\n"+
                "3.Telebe menusu\n"+
                "0.Cixis"
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
                System.out.println("Secim yanlisdir");

        }

    }
}