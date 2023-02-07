package controller;

import model.Product;
import storage.ReadWriteFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    List<Product> products;


    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public ProductManager(List<Product> products) {
        this.products = products;
    }

    public void addNewProduct(Product product){
        products.add(product);
        ReadWriteFile.writeFile(products);
    }

    public void deleteByProduct(){
        products.remove(products.size()-1);
        ReadWriteFile.readFile();
    }
}
