package coursemanagement.dao;

import coursemanagement.commond.DbConnection;
import coursemanagement.course.entity.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public void addCourse(Course course) {
        String sql = "INSERT INTO school.courses (name) VALUES(?)";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, course.getCourseName());
            ps.executeUpdate();
            System.out.println("Kurs əlavə olundu!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Course> listCourse() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT*FROM school.courses ORDER BY id ASC";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getInt("id"));
                course.setCourseName(rs.getString("name"));
                courses.add(course);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return courses;
    }

    public Course findById(long id) {
        String sql = "SELECT*FROM school.courses WHERE id=?";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Course course = new Course();
                    course.setCourseID(rs.getInt("id"));
                    course.setCourseName(rs.getString("name"));
                    return course;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCourse(Course course) {
        String sql = "UPDATE school.courses SET name=? WHERE id=?";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, course.getCourseName());
            ps.setInt(2, course.getCourseID());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Kurs uğurla yeniləndi!");
            } else {
                System.out.println("Yenilənəcək kurs tapılmadı");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteCourse(int id) {
        String sql = "DELETE FROM school.courses WHERE id=?";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTeacherToCourse(int courseId, int teacherId) {
        String sql = "UPDATE school.courses SET teacher_id=? WHERE id=?";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, teacherId);
            ps.setInt(2, courseId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Müəllim kursa əlavə olundu!");
            } else {
                System.out.println("Belə kurs tapılmadı!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addStudentToCourse(int courseId, int studentId) {
        String sql = "INSERT INTO school.course_students (student_id,course_id) VALUES (?,?)";
        try (Connection conn = DbConnection.connection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Tələbə kursa əlavə olundu!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
