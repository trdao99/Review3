package tonghop1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Method productManager = new descriptionMethod();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("***********************MENU**************************\n" +
                    "1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Tính lợi nhuận các sản phẩm\n" +
                    "4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần\n" +
                    "5. Thống kê các sản phẩm theo giá\n" +
                    "6. Tìm các sản phẩm theo tên sản phẩm\n" +
                    "7. Nhập sản phẩm\n" +
                    "8. Bán sản phẩm\n" +
                    "9. Cập nhật trạng thái sản phẩm\n" +
                    "10. Thoát");
            System.out.println("============================================");
            System.out.println("chọn chức năng đê : ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.displayData();
                    break;
                case 3:
                    productManager.profitProduct();
                    break;
                case 4:
                    productManager.sortProfit();
                    break;
                case 5:
                    productManager.PriceSearch();
                    break;
                case 6:
                    productManager.findByName();
                    break;
                case 7:productManager.addQuantity();
                    break;
                case 8:
                    productManager.sellProduct();
                    break;
                case 9:
                    productManager.changeStatus();
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}







