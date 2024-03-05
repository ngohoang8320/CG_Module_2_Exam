package repo;

import entity.Product;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class WriteReadFile {
    private File file = new File("src/data/products.csv");

    private void checkFile() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void writeFile(ArrayList<Product> productList) {
        checkFile();
        try {
            Files.writeString(file.toPath(),
                    "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Product prod : productList) {
            String prodLine = prod.getId()
                              + ","
                              + prod.getName()
                              + ","
                              + prod.getPrice()
                              + ","
                              + prod.getQuantity()
                              + ","
                              + prod.getDescription()
                              + ",\n";
            try {
                Files.writeString(file.toPath(),
                        prodLine,
                        StandardCharsets.UTF_8,
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Done with write file!");
    }

    public ArrayList<Product> readFile(ArrayList<Product> productList) {
        try {
            productList.clear();
            List<String> listString = Files.readAllLines(file.toPath(),
                    StandardCharsets.UTF_8);
            for (String prodString : listString) {
                String[] prodElementString = prodString.split(",");
                Product product = new Product(Integer.parseInt(prodElementString[0]),
                        prodElementString[1],
                        Double.parseDouble(prodElementString[2]),
                        Integer.parseInt(prodElementString[3]),
                        prodElementString[4]);
                productList.add(product);
            }
            return productList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
