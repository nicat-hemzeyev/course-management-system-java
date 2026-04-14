package coursemanagement.teacher.entity;

import coursemanagement.commond.User;

public class Teacher extends User {
    private int salary;

    public Teacher(String name, String surname,int age, String email, int salary) {
        super(name, surname,age,email);
        this.salary = salary;

    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
@Override
    public String toString() {
    System.out.print("Teacher ");
        return " name: " + getName() + "," +
                " surname: " + getSurname() + "," +
                " age: " + getAge() + "," +
                " email: " + getEmail() + "," +
                " salary: " + getSalary() + ",";
    }
}
