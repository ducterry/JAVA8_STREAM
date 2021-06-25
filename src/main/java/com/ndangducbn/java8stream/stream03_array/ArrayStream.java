package com.ndangducbn.java8stream.stream03_array;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayStream {
    public static Stream<String> createStream(){
        String[] array = new String[]{"A","B","C"};
        return Arrays.stream(array);
    }
}
