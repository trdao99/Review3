package tonghop1;

import java.util.Scanner;

public class descriptionMethod implements Method {
    public static Product[] productlist = new Product[100];
    public static int count = 0;
    Scanner scanner = new Scanner(System.in);

    @Override
    public Product inputData() {
        Product newProduct = new Product();
        do {
            System.out.println("input ID : ");
            String productID = scanner.nextLine();
            boolean IdExists = false;
            if (productID.startsWith("P") & productID.length() == 4) {
                for (int i = 0; i < count; i++) {
                    if (productlist[i].getProductName().equals(productID)) {
                        IdExists = true;
                        System.err.println("ID already exists");
                        break;
                    }
                }
                if (!IdExists) {
                    newProduct.setProductid(productID);
                    break;
                }
            } else {
                System.err.println("Must start with P and have 4 character.");
            }
        } while (true);

        do {
            System.out.println("Input Name: ");
            String productName = scanner.nextLine();

            if (productName.length() >= 4 && productName.length() <= 50) {
                boolean nameExists = false;

                for (int i = 0; i < count; i++) {
                    if (productlist[i].getProductName().equals(productName)) {
                        nameExists = true;
                        System.err.println("Name already exists");
                        break;
                    }
                }

                if (!nameExists) {
                    newProduct.setProductName(productName);
                    break;
                }
            } else {
                System.err.println("Must have 4-50 characters.");
            }
        } while (true);

        do {
            System.out.println("input import price");
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                newProduct.setImportPrice(importPrice);
                break;
            } else {
                System.err.println("Must be greater than 0");
            }
        } while (true);

        do {
            System.out.println("input export price");
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if (exportPrice > (newProduct.getImportPrice() + (newProduct.getImportPrice() * (20 / 100)))) {
                newProduct.setExportPrice(exportPrice);
                break;
            } else {
                System.err.println("Must be greater than the import price by 20%");
            }
        } while (true);

        newProduct.setProfit(newProduct.getExportPrice() - newProduct.getImportPrice());
        do {
            System.out.println("input quantity");
            int Quantity = Integer.parseInt(scanner.nextLine());
            if (Quantity > 0) {
                newProduct.setQuantity(Quantity);
                break;
            } else {
                System.err.println("Must be greater than 0");
            }
        } while (true);
        System.out.println("input descriptions");
        newProduct.setDescriptions(scanner.nextLine());
        do {
            System.out.println("input status(0: selling/1: sold out)");
            int choose = Integer.parseInt(scanner.nextLine());
            if (choose == 0) {
                newProduct.setStatus(true);
                break;
            } else if (choose == 1) {
                newProduct.setStatus(false);
                break;
            } else {
                System.err.println("just choose 0 or 1");
            }
        } while (true);

        return newProduct;
    }

    @Override
    public void displayData() {
        for (int i = 0; i < count; i++) {
            System.out.printf("ID: %s | Name: %s | importPrice : %f | exportPrice : %f | quantity: %d | \n", productlist[i].getProductid(), productlist[i].getProductName(), productlist[i].getImportPrice(), productlist[i].getExportPrice(), productlist[i].getQuantity());
            System.out.printf("\t descriptions: %s | status: %s\n", productlist[i].getDescriptions(), (productlist[i].isStatus() ? "selling" : "sold out"));
            System.out.println("=====================================================");
        }
    }

    @Override
    public void profitProduct() {
        for (int i = 0; i < count; i++) {
            System.out.printf("ID : %s || Name : %s || profit : %f\n", productlist[i].getProductid(), productlist[i].getProductName(), productlist[i].getProfit());
        }
    }

    @Override
    public void sortProfit() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                Product temp = new Product();
                if (productlist[i].getProfit() < productlist[j].getProfit()) {
                    temp = productlist[i];
                    productlist[i] = productlist[j];
                    productlist[j] = temp;
                }
            }
        }
        displayData();
    }

    @Override
    public void PriceSearch() {
        System.out.print("start price: ");
        float start = Float.parseFloat(scanner.nextLine());
        System.out.print("end price: ");
        float end = Float.parseFloat(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            if (productlist[i].getExportPrice() <= end && productlist[i].getExportPrice() >= start) {
                System.out.println(productlist[i].toString());
            }
        }
    }

    @Override
    public void findByName() {
        System.out.println("input FIndName: ");
        String FindName = scanner.nextLine().toLowerCase();
        boolean checkFind = true;
        for (int i = 0; i < count; i++) {
            if (productlist[i].getProductName().toLowerCase().equals(FindName)) {
                System.out.println(productlist[i].toString());
                checkFind = false;
            }
        }
        if (checkFind) {
            System.err.println("Name doesnt exit");
        }
    }

    @Override
    public void addQuantity() {
        System.out.println("input ID wanna add quantity");
        String AddQuantity = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (productlist[i].getProductid().equals(AddQuantity)) {
                System.out.printf("ID : %s || Name : %s || Quantity : %d\n", productlist[i].getProductid(), productlist[i].getProductName(), productlist[i].getQuantity());
                System.out.print("số quantity muốn add : ");
                productlist[i].setQuantity(productlist[i].getQuantity() + Integer.parseInt(scanner.nextLine()));
                System.out.printf("ID : %s || Name : %s || Quantity : %d\n", productlist[i].getProductid(), productlist[i].getProductName(), productlist[i].getQuantity());
                break;

            }
        }
    }

    @Override
    public void sellProduct() {
        boolean checkName = true;
        System.out.println("Enter the name of the product you want to sell: ");
        String sellName = scanner.nextLine().toLowerCase();

        for (int i = 0; i < count; i++) {
            if (productlist[i].getProductName().toLowerCase().equals(sellName)) {
                checkName = false;
                System.out.println(productlist[i].toString());
                System.out.print("Enter the quantity you want to sell: ");
                int sellQuantity = 0;

                try {
                    sellQuantity = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid quantity entered. Please enter a valid integer.");
                    return; // Exit the method if an invalid quantity is entered
                }

                productlist[i].setQuantity(productlist[i].getQuantity() - sellQuantity);

                if (productlist[i].getQuantity() == 0) {
                    productlist[i].setStatus(false);
                }

                System.out.println(productlist[i].toString());

                if (productlist[i].getQuantity() == 0) {
                    for (int j = i; j < count - 1; j++) {
                        productlist[j] = productlist[j + 1];
                    }

                    productlist[count - 1] = null;
                    count--;
                }

                break;
            }
        }

        if (checkName) {
            System.err.println("Product name does not exist.");
        }
    }

    @Override
    public void addProduct() {
        System.out.println("nhập số sản phẩm muốn thêm");
        int addNum = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < addNum; i++) {
            productlist[i] = inputData();
            count++;
        }

    }

    @Override
    public void changeStatus() {
        System.out.println("input ID wanna change");
        String IDchange = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (productlist[i].getProductid().equals(IDchange)) {
                productlist[i].setStatus(!productlist[i].isStatus());
                if(productlist[i].isStatus() == false ){
                    productlist[i].setQuantity(0);
                }
            }
        }
    }
}
