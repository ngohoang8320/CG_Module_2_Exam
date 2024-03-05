package services;

import entity.Product;
import view.NewPage;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveProduct {
    private Scanner input = new Scanner(System.in);

    public ArrayList<Product> remove(ArrayList<Product> productList) {
        NewPage.newPage();
        System.out.print("Nhập vào mã sản phẩm: ");
        int id = input.nextInt();
        input.nextLine();

        for (Product prod : productList) {
            if (id == prod.getId()) {
                productList.remove(prod);
            }
            break;
        }
        return productList;
    }
}
