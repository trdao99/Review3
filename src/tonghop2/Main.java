package tonghop2;

import tonghop2.business.DescriMethod;
import tonghop2.businessImp.Employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DescriMethod employee = new DescriMethod();
        do {
            System.out.println("********************MENU*********************\n" +
                    "1. Nhập thông tin cho n nhân viên\n" +
                    "2. Hiển thị thông tin nhân viên\n" +
                    "3. Tính lương cho các nhân viên\n" +
                    "4. Tìm kiếm nhân viên theo tên nhân viên\n" +
                    "5. Cập nhật thông tin nhân viên\n" +
                    "6. Xóa nhân viên theo mã nhân viên\n" +
                    "7. Sắp xếp nhân viên theo lương tăng dần (Comparable)\n" +
                    "8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)\n" +
                    "9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)\n" +
                    "10. Thoát");
            System.out.println("choose");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:employee.addEm();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    employee.edit();
                    break;
                case 6:employee.del();
                    break;
                case 7:employee.sortBySalary();
                    break;
               case 8:
                   employee.sortName();
                    break;
                case 9:employee.sortByYear();
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
