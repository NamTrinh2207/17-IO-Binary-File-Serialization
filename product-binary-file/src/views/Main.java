package views;

import controller.ProductManager;
import model.Product;
import storage.ReadWriteFile;
import java.util.List;

public class Main {
    public static List<Product> products = ReadWriteFile.readFile();
    public static ProductManager product = new ProductManager(products);
    public static void main(String[] args) {
        product.addNewProduct(new Product("1","Sang sung 0","1000",50000));
        product.addNewProduct(new Product("1","Sang sung 0","1000",50000));
        product.deleteByProduct();
        for (Product p: products
             ) {
            System.out.println(p);
        }
    }
}
