package services;

import entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
    public ArrayList<Product> sort(ArrayList<Product> productList) {
        Comparator<Product> priceComparator = Comparator.comparingDouble(Product::getPrice);
        Collections.sort(productList,
                priceComparator);
        return productList;
    }
}
