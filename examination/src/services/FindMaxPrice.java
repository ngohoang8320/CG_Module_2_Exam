package services;

import entity.Product;

import java.util.ArrayList;

public class FindMaxPrice {
    public void find(ArrayList<Product> productList) {
        double max = 0;
        ArrayList<Product> listMaxProduct = new ArrayList<>();
        for (Product prod : productList) {
            if (prod.getPrice() > max) {
                max = prod.getPrice();
            }
        }
        for (Product prod : productList) {
            if (prod.getPrice() == max) {
                listMaxProduct.add(prod);
            }
        }

        ShowProductList showProductList = new ShowProductList();
        showProductList.show(listMaxProduct);
    }

}
