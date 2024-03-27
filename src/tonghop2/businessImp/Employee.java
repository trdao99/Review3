package tonghop2.businessImp;

import tonghop2.business.IEmployee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Employee implements IEmployee {

    private String Id;
    private String Name;
    private int Year;
    private float Rate;
    private float Commission;
    private float Salary;
    private boolean Status;

    public Employee() {
    }

    public Employee(String id, String name, int year, float rate, float commission, float salary, boolean status) {
        Id = id;
        Name = name;
        Year = year;
        Rate = rate;
        Commission = commission;
        Salary = salary;
        Status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float rate) {
        Rate = rate;
    }

    public float getCommission() {
        return Commission;
    }

    public void setCommission(float commission) {
        Commission = commission;
    }

    public float getSalary() {
        return Salary = Rate * BASIC_SALARY + Commission;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    Scanner sc = new Scanner(System.in);
    public static Employee[] employeeslist = new Employee[100];
    public static int count = 0;
    boolean flag = true;


    @Override
    public Employee inputData() {
        Employee employee = new Employee();
        do {
            System.out.println("nhập tên: ");
            String newName = sc.nextLine();
            if (newName.trim().isEmpty()) {
                System.err.println("nhập lại ");
            } else {
                employee.Name = newName;
                break;
            }
        } while (true);

        if (flag) {
            do {
                System.out.println("nhập ID: ");
                String newID = sc.nextLine();
                if (newID.trim().isEmpty()) {
                    System.err.println("nhập lại ");
                } else {
                    employee.Id = newID;
                    break;
                }
            } while (true);
        }
        do {
            System.out.println("nhập năm sinh nhân viên: ");
            int newYear = Integer.parseInt(sc.nextLine());
            if (newYear <= 0) {
                System.err.println("nhập lại ");
            } else {
                employee.Year = newYear;
                break;
            }
        } while (true);
        do {
            System.out.println("nhập hệ số lương nhân viên: ");
            float newRate = Float.parseFloat(sc.nextLine());
            if (newRate <= 0) {
                System.err.println("nhập lại ");
            } else {
                employee.Rate = newRate;
                break;
            }
        } while (true);
        do {
            System.out.println("nhập hoa hồng nhân viên hàng tháng: ");
            float newCommission = Float.parseFloat(sc.nextLine());
            if (newCommission <= 0) {
                System.err.println("nhập lại ");
            } else {
                employee.Commission = newCommission;
                break;
            }
        } while (true);
        do {
            System.out.println("nhập trạng thái:(0: đang làm/1: nghỉ việc )");
            int choose = Integer.parseInt(sc.nextLine());
            if (choose == 0) {
                employee.Status = true;
                break;
            } else if (choose == 1) {
                employee.Status = false;
                break;
            } else {
                System.err.println("just choose 0 or 1");
            }
        } while (true);

        return employee;
    }

    @Override
    public void displayData() {
        for (int i = 0; i < count; i++) {
            System.out.printf("ID : %s | Name : %s | Year : %d | Rate : %f | Hoa Hồng : %f | Salary : %f | Status : %S \n", this.Name, this.Id, this.Rate, this.Commission, this.Salary, (this.Status ? "đang làm" : "nghỉ việc"));
            System.out.println("\t_______________________________________________________________________________");
        }
    }

    @Override
    public String toString() {
        return String.format("ID : %s | Name : %s | Year : %d | Rate : %f | Hoa Hồng : %f | Salary : %f | Status : %S \n", this.Name, this.Id, this.Rate, this.Commission, this.Salary, (this.Status ? "đang làm" : "nghỉ việc"));
    }
}

