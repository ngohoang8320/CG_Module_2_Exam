package services;

import entity.Product;
import view.NewPage;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateProduce {
    private Scanner input = new Scanner(System.in);

    public ArrayList<Product> update(ArrayList<Product> productList) {
        NewPage.newPage();
        System.out.print("Nhập vào mã sản phẩm: ");
        int id = input.nextInt();
        input.nextLine();
        for (Product prod : productList) {
            if (id == prod.getId()) {
                System.out.print("Nhập mã sản phẩm: ");
                int newId = input.nextInt();
                input.nextLine();
                prod.setId(newId);

                String newName = input.nextLine();
                prod.setName(newName);

                double newPrice = input.nextDouble();
                input.nextLine();
                prod.setPrice(newPrice);

                int newQuantity = input.nextInt();
                input.nextLine();
                prod.setPrice(newQuantity);

                String newDes = input.nextLine();
                prod.setDescription(newDes);
            }
            break;
        }
        return productList;
    }
}
