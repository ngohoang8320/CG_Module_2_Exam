package services;

import controller.MenuController;
import entity.Product;
import exception.NotNull;
import view.NewPage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddProduct {
    private Scanner input = new Scanner(System.in);

    public ArrayList<Product> add(ArrayList<Product> productList) {
        NewPage.newPage();
        System.out.println("Nhập vào thông tin sản phẩm!");

        try {
            System.out.print("Mã sản phẩm: ");
            int id = input.nextInt();
            input.nextLine();

            System.out.print("Tên sản phẩm: ");
            String name = input.nextLine();
            if (name.length() == 0) {
                throw new NotNull("Not Null!");
            }

            System.out.print("Giá: ");
            double price = input.nextDouble();
            input.nextLine();

            System.out.print("Số lượng: ");

            int quantity = input.nextInt();
            input.nextLine();

            System.out.println("Mô tả: ");
            String description = input.nextLine();

            Product product = new Product(id,
                    name,
                    price,
                    quantity,
                    description);

            productList.add(product);
        } catch (InputMismatchException e) {
            System.out.println("Sai định dạng, phải nhập số tại vị trí này!");
            System.out.println("Bấm Enter để quay lại trang Menu.");
            input.nextLine();
            MenuController.menuController();
        } catch (NotNull n) {
            System.out.println("Mục này không được phép để trống.");
            System.out.println("Bấm Enter để quay lại trang Menu.");
            input.nextLine();
            MenuController.menuController();
        }
        return productList;
    }
}
