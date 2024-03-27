package tonghop2.business;

import tonghop2.businessImp.Employee;

import java.util.Arrays;
import java.util.Scanner;

import static tonghop2.businessImp.Employee.count;
import static tonghop2.businessImp.Employee.employeeslist;

public class DescriMethod {
    Scanner sc = new Scanner(System.in);
    boolean flag = true;



    public  void addEm() {
        System.out.println("số nhân viên muốn thêm: ");
        int addNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < addNum; i++) {
            employeeslist[i].inputData();
            count++;
        }
    }


    public void edit() {
        System.out.println("chọn ID muốn thay đổi");
        String editID = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (employeeslist[i].getId().equals(editID)) {
                flag = false;
                employeeslist[i].inputData();
            }
        }
    }

    public void del() {
        System.out.println("Enter the ID you want to delete: ");
        String delID = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (employeeslist[i].getId().equals(delID)) {
                for (int k = i; k < count - 1; k++) {
                    employeeslist[k] = employeeslist[k + 1];
                }
                employeeslist[count - 1] = null;
                count--;
                break; // Terminate the loop after deleting the employee
            }
        }
    }

    public void sortBySalary(){
        Arrays.sort(employeeslist, (o1, o2) -> Float.compare(o1.getSalary(), o2.getSalary()));
        for (int i = 0; i < count; i++) {
            employeeslist[i].toString();
        }
    }
    public void sortName(){
        Arrays.sort(employeeslist, (o1,o2) -> o1.getName().compareTo(o2.getName()));
        for (int i = 0; i < count; i++) {
            employeeslist[i].toString();
        }
    }

    public void sortByYear(){
        Arrays.sort(employeeslist, (o1,o2) -> o1.getYear()- o2.getYear());
        for (int i = 0; i < count; i++) {
            employeeslist[i].toString();
        }
    }

}


