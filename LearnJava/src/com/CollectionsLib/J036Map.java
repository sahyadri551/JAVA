package com.CollectionsLib;

import java.util.Map;
import java.util.HashMap;
public class J036Map {
    static void main() {
        Map<String,String> m = Map.of("Apple","Red","Banana","Yellow","Orange","Orange");
        System.out.println(m);
        //m.put("Mango","Green"); // This will throw UnsupportedOperationException because Map.of() returns an immutable map
        //m.remove("Apple");// this will throw UnsupportedOperationException
        Map <String,Integer> m1 = new HashMap<>();
        m1.put("Apple",10);
        m1.put("Banana",20);
        m1.put("Orange",30);
        m1.put("Mango",40);
        System.out.println(m1);
        System.out.println(m1.get("Apple"));
        System.out.println(m1.getOrDefault("Apple",100));// if the key is not present in the map, then it will return 100
        System.out.println(m1.containsKey("Apple"));
        System.out.println(m1.containsValue(10));
        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.toString());
        System.out.println(m1.keySet());
        System.out.println(m1.values());
        System.out.println(m1.entrySet());
        m1.forEach((k,v) -> System.out.println(k + " : " + v));
        m1.replace("Apple", 100);
        m1.replace("Banana", 200, 300);
        m1.putIfAbsent("Pineapple", 400);
        m1.remove("Pineapple");// it will remove the key and value pair from the map
        m1.computeIfPresent("Apple", (k,v) -> v + 100);
        m1.computeIfAbsent("Mango", k -> 500);
        m1.compute("Apple", (k,v) -> v + 100);
        m1.merge("Apple", 100, Integer::sum);// it will add the value of the key to the existing value
        Utility.print(m1);
        m1.clear();
    }
}