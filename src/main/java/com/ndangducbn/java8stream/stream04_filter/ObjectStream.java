package com.ndangducbn.java8stream.stream04_filter;

import java.util.ArrayList;
import java.util.List;

public class ObjectStream {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "HP Laptop", 25000f));
        productList.add(new Product(2, "Dell Laptop", 30000f));
        productList.add(new Product(3, "Lenevo Laptop", 28000f));
        productList.add(new Product(4, "Sony Laptop", 28000f));
        productList.add(new Product(5, "Apple Laptop", 90000f));
    }

    public static List<Product> createProductList(){
        return productList;
    }
}
