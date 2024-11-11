package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length < 2) {
            return;
        }

        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        List<Product> products = read(fileName);

        switch (args[0]) {
            case "-u":
                update(fileName, args, products);
                break;
            case "-d":
                delete(fileName, args, products);
                break;
        }
    }

    public static List<Product> read(String fileName) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while (fileReader.ready()) {
                line = fileReader.readLine();
                products.add(new Product(Integer.parseInt(line.substring(0,8).trim()),
                        line.substring(8, 38).trim(), line.substring(38, 46).trim(),
                        line.substring(46).trim()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void update(String fileName, String[] args, List<Product> products) {
        if (args.length < 5) {
            return;
        }

        for (Product product : products) {
            if (product.getId() == Long.parseLong(args[1])) {
                String productName = "";
                for (int i = 2; i < args.length - 2; i++) {
                    productName += args[i] + " ";
                }
                productName = productName.trim();
                product.setProductName(productName);
                product.setPrice(args[args.length - 2]);
                product.setQuantity(args[args.length - 1]);
            }
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Product product : products) {
                fileWriter.write(product.toString() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(String fileName, String[] args, List<Product> products) {
        products.removeIf(product -> product.getId() == Long.parseLong(args[1]));

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Product product : products) {
                fileWriter.write(product.toString() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Product {
        private long id;
        private String productName;
        private String price;
        private String quantity;

        public Product(long id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, productName, price, quantity);
        }

        public long getId() {
            return this.id;
        }

        public void setProductName(String productName) {
            if (productName.length() > 30) {
                this.productName = productName.substring(0, 30);
            } else {
                this.productName = productName;
            }
        }

        public void setPrice(String price) {
            if (price.length() > 8) {
                this.price = price.substring(0,8);
            } else {
                this.price = price;
            }
        }

        public void setQuantity(String quantity) {
            if (quantity.length() > 4) {
                this.quantity = quantity.substring(0, 4);
            } else {
                this.quantity = quantity;
            }
        }
    }
}
