package com.hammad.datastructures.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> numbers = new HashMap<>();
        System.out.println(numbers.put("one",1));
        System.out.println(numbers.put("one",2));
    }
}
