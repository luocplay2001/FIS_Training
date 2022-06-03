package com.example;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamTest {

    private final Predicate<String>
            predicateStr = s -> {return s.startsWith("N");};

    private final Consumer<String>
            consumerStr = s -> System.out.println(s);



    @Test
    void testOfFunction() {
        List<String> list = Arrays.asList("Kien","Quyet","Chien","Kien","Nam");
        list.stream()
            .distinct()
                .filter(predicateStr)
            .sorted(Comparator.reverseOrder())
                .distinct().forEach(consumerStr);
    }

    @Test
    void testFunctionMap() {


        try {
            Stream<String> stringStream = Files.lines(Paths.get("test/test.txt"));

            long noOfWords = stringStream
                    .flatMap(l -> Arrays.stream(l.split(" +")))
                    .distinct()
                    .count();
            System.out.println("No of Words: " + noOfWords);
        } catch (Exception e) {

        }
    }
}
