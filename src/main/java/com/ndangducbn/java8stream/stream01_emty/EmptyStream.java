package com.ndangducbn.java8stream.stream01_emty;

import java.util.List;
import java.util.stream.Stream;

public class EmptyStream {
    public static Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
}
