package coursemanagement.dao;

import coursemanagement.commond.DbConnection;
import coursemanagement.teacher.entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    public void addTeacher(Teacher teacher) {
        String sqlTeacher = "INSERT INTO school.teachers(name, surname, age, email, salary) VALUES(?,?,?,?,?)";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sqlTeacher)) {
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());
            ps.setInt(3, teacher.getAge());
            ps.setString(4, teacher.getEmail());
            ps.setLong(5, teacher.getSalary());
            ps.executeUpdate(); // vacibdir!
            System.out.println("Müəllim əlavə olundu!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> listTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM school.teachers ORDER BY id ASC ";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setSurname(rs.getString("surname"));
                teacher.setAge(rs.getInt("age"));
                teacher.setEmail(rs.getString("email"));
                teacher.setSalary(rs.getInt("salary"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public Teacher findById(long id) {
        String sql = "SELECT * FROM school.teachers WHERE id=?";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getInt("id"));
                    teacher.setName(rs.getString("name"));
                    teacher.setSurname(rs.getString("surname"));
                    teacher.setAge(rs.getInt("age"));
                    teacher.setEmail(rs.getString("email"));
                    teacher.setSalary(rs.getInt("salary"));
                    return teacher;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // tapılmadıqda null
    }

    public void updateTeacher(Teacher teacher) {
        String sql = "UPDATE school.teachers SET name=?, surname=?, age=?, email=?, salary=? WHERE id=?";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());
            ps.setInt(3, teacher.getAge());
            ps.setString(4, teacher.getEmail());
            ps.setInt(5, teacher.getSalary());
            ps.setInt(6, teacher.getId());

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

    public void deleteTeacher(int id) {
        String sql = "DELETE FROM school.teachers WHERE id=?";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


