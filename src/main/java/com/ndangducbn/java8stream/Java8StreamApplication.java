package com.ndangducbn.java8stream;

import com.ndangducbn.java8stream.stream01_emty.EmptyStream;
import com.ndangducbn.java8stream.stream02_collections.CollectionStream;
import com.ndangducbn.java8stream.stream03_array.ArrayStream;
import com.ndangducbn.java8stream.stream04_filter.ObjectStream;
import com.ndangducbn.java8stream.stream04_filter.Product;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Java8StreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java8StreamApplication.class, args);

        // 01. Empty Stream
        Stream<String> emptyStream = EmptyStream.streamOf(new ArrayList<>());

        emptyStream.forEach(System.out::println);
        System.out.println("=========================================");

        // 02. Collection Stream
        Stream<String> collectionStream = CollectionStream.createStream();

        collectionStream.forEach(System.out::println);
        System.out.println("=========================================");
        // 03. Arrays Stream
        Stream<String> arrayStream = ArrayStream.createStream();

        arrayStream.forEach(System.out::println);
        System.out.println("=========================================");
        // 04. Filter Object Stream
        List<Product> productList = ObjectStream.createProductList();
        /*
            - Lọc các sản phẩm có giá trên 25.000
         */
        List<Product> priceProductThan25000 = productList.stream()
                .filter(product -> product.getPrice() >= 25000)
                .collect(Collectors.toList());

        priceProductThan25000.forEach(System.out::println);
        System.out.println("=========================================");

        /*
            - Lọc các sản phẩm có giá trên 25.000
            - Chỉ in ra giá
         */
        List<Float> priceThan25000 = productList.stream()
                .map(Product::getPrice)
                .filter(price -> price >= 25000)
                .collect(Collectors.toList());
        priceThan25000.forEach(System.out::println);
        System.out.println("=========================================");


        /*
            - Tính tổng giá tiền
         */
        double totalPrice = productList.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total Price: " + totalPrice);
        System.out.println("=========================================");

        /*
            - Tính Min
            - Tính Max
         */
        Product prodMax = productList
                .stream()
                .max((prod1, prod2) -> prod1.getPrice() >= prod2.getPrice() ? 1 : -1)
                .get();
        Product prodMin = productList
                .stream()
                .max((prod1, prod2) -> prod1.getPrice() >= prod2.getPrice() ? -1 : 1)
                .get();
        System.out.println("Max Price: " + prodMax);
        System.out.println("Min Price: " + prodMin);
        System.out.println("=========================================");

         /*
            - Convert List => Set
         */

        Set<Float> setProduct = productList
                .stream()
                .map(Product::getPrice)
                .filter(price -> price >= 30000)
                .collect(Collectors.toSet());
        System.out.println("Set Prod: " + setProduct);
        System.out.println("=========================================");

        /*
            - Convert List => Map
         */

        Map<Integer, Float> mapProd = productList
                .stream()
                .collect(Collectors.toMap(Product::getId, Product::getPrice));
        System.out.println("MAP Prod: " + mapProd);
        System.out.println("=========================================");

        /*
            - Sort theo Price giảm dần
         */

        List<Float> sortPriceProd = productList
                .stream()
                .map(Product::getPrice)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Price Prod: " + sortPriceProd);
        System.out.println("=========================================");
    }

}
