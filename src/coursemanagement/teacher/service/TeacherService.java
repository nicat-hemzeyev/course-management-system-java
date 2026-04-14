package coursemanagement.teacher.service;

import coursemanagement.commond.Db;
import coursemanagement.teacher.entity.Teacher;

import java.util.Scanner;

public class TeacherService {
    public static void addTeacher() {
        System.out.println("Neche nefer muellim elave edeceksiz?");
        int count = new Scanner(System.in).nextInt();
        Teacher[] teachers=new Teacher[count];
        Scanner sc =new Scanner(System.in);
        for(int i=0;i<count;i++){
            System.out.println((i+1)+".");
            System.out.println("Muellimin adini daxil edin:");
            String name =sc.nextLine();
            System.out.println("Muellimin soyadini daxil edin:");
            String surName = sc.nextLine();
            System.out.println("Muellimin yashini daxil edin:");
            byte age = sc.nextByte(); sc.nextLine();
            System.out.println("Muellimin emailini daxil edin:");
            String eMail =sc.nextLine();
            System.out.println("Muellimin maasini daxil edin:");
            short salary =sc.nextShort(); sc.nextLine();
            Teacher teacher =new Teacher(name,surName,age,eMail,salary);
            teachers[i]=teacher;
        } Db.teachers=teachers;
    }

    public static void listTeacher() {
        Teacher[] teachers =Db.teachers;
        System.out.println("Qeydiyyatdan kechen muellimler:");
        for(int i=0;i<teachers.length;i++){
            if(teachers[i]==null)continue;
            System.out.println((i+1)+".\n"+teachers[i]);
        }
    }

    public static void assignTeacherToCourse() {
    }

    public static void removeTeacher() {
        Teacher[] teachers=Db.teachers;
        System.out.println("Neche nomreli muellimi silmek isteyirsiz?");
        int number=new Scanner(System.in).nextInt();
        teachers[number-1]=null;
        System.out.println("Muellim silindi");

    }
}
