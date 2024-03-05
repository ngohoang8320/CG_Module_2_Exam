package controller;

import entity.Product;
import repo.WriteReadFile;
import services.*;
import view.MenuPage;
import view.NewPage;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Product> productList = new ArrayList<>();
    private static WriteReadFile writeReadFile = new WriteReadFile();

    public static void menuController() {
        NewPage.newPage();
        MenuPage menuPage = new MenuPage();
        menuPage.printMenu();
        String choice = input.nextLine();

        switch (choice) {
            case "1":
                ShowProductList showProductList = new ShowProductList();
                showProductList.show(productList);
                menuController();
            case "2":
                AddProduct addProduct = new AddProduct();
                addProduct.add(productList);
                menuController();
            case "3":
                UpdateProduce updateProduce = new UpdateProduce();
                updateProduce.update(productList);
                menuController();
            case "4":
                RemoveProduct removeProduct = new RemoveProduct();
                removeProduct.remove(productList);
                menuController();
            case "5":
                Sort sort = new Sort();
                sort.sort(productList);
                menuController();
            case "6":
                FindMaxPrice findMaxPrice = new FindMaxPrice();
                findMaxPrice.find(productList);
                menuController();
            case "7":
                productList = writeReadFile.readFile(productList);
                menuController();
            case "8":
                writeReadFile.writeFile(productList);
                menuController();
            case "9":
                break;
            default:

        }
    }
}
