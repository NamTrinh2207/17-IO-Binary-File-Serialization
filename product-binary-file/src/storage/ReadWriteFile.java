package storage;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static boolean writeFile(List<Product> products) {
        File file = new File("product.txt");
        OutputStream os;
        try {
            os = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedOutputStream bf = new BufferedOutputStream(os);
        try {
            ObjectOutputStream obj = new ObjectOutputStream(bf);
            obj.writeObject(products);
            obj.close();
            bf.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Product> readFile() {
        File file = new File("product.txt");
        InputStream is;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedInputStream bf = new BufferedInputStream(is);
        ObjectInputStream ins = null;
        try {
            ins = new ObjectInputStream(bf);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (ins != null) {
                List<Product> list;
                try {
                    list = (List<Product>) ins.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                return list;
            } else {
                return new ArrayList<>();
            }
        }
    }
}
