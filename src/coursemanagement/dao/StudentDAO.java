package coursemanagement.dao;

import coursemanagement.commond.DbConnection;
import coursemanagement.student.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
    public void addStudent(Student student) {
        String sql = "INSERT INTO school.students (name,surname,age,email) VALUES(?,?,?,?)";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getEmail());
            ps.executeUpdate();//INSERT, UPDATE, DELETE kimi sorğuları icra edir
            System.out.println("Tələbə əlavə olundu!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> listStudent() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT*FROM school.students ORDER BY id ASC";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();//Bu metod SELECT sorğusunu işlədir və nəticələri ResultSet obyektində saxlayır.
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setAge(rs.getInt("age"));
                student.setEmail(rs.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student findById(long id){
        String sql = "SELECT*FROM school.students WHERE id=?";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setAge(rs.getInt("age"));
                    student.setEmail(rs.getString("email"));
                    return student;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE school.students SET name=?, surname=?, age=?,email=? WHERE id=?";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getEmail());
            ps.setInt(5, student.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Müəllim məlumatları uğurla yeniləndi!");
            } else {
                System.out.println("Yenilənəcək müəllim tapılmadı.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM school.students WHERE id=?";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
