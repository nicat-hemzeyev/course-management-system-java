package coursemanagement.teacher.entity;
import coursemanagement.commond.User;

public class Teacher extends User {
   private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
