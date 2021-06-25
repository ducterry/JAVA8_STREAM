package com.ndangducbn.java8stream.stream02_collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CollectionStream {
    public static Stream<String> createStream(){
        Collection<String> collections = Arrays.asList("VIETNAM","CAMPUCHIA","LAO");
        return collections.stream();
    }


}
