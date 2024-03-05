package services;

import entity.Product;
import view.NewPage;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowProductList {
    private Scanner input = new Scanner(System.in);

    public void show(ArrayList<Product> productList) {
        NewPage.newPage();
        int count = 0;
        for (Product prod : productList) {
            if (count % 5 != 0 || count == 0) {
                System.out.println(prod.toString());
            } else {
                input.nextLine();
                System.out.println(prod.toString());
            }
            count++;
        }
        input.nextLine();
    }
}
