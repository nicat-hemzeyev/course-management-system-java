package coursemanagement.storage;

import coursemanagement.student.entity.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentFileManager {
    private static final String FILE_NAME = "student.txt";

    //fayla yazmaq
    public static void saveStudent(Student student) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(student.getName() + "," + student.getId() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //fayli oxumaq
    public static void loadStudents(Student[] students) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
              //  students[index++] = new Student(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

