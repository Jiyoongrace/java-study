package prob04;

public class Depart extends Employee {
    String department;

    public Depart(String department) {
        this.department = department;
    }

    public Depart(String name, int salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    public void getInformation() {
        System.out.println("이름: " + getName() + "\t연봉: " + getSalary() + "\t부서: " + department);
    }
}
