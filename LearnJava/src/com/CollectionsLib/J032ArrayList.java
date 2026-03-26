package com.CollectionsLib;

import java.util.ArrayList;
public class J032ArrayList {
    static void main() {
        // ArrayList list1 = new ArrayList(); -> Dynamic Array List any type of data can be stored
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Mango");
        list.add("Pineapple");
        list.add("Grapes");
        list.add("Strawberry");
        list.add("Cherry");
        list.add("Apple");

        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains("Apple"));
        System.out.println(list.indexOf("Apple"));
        System.out.println(list.lastIndexOf("Apple"));
        System.out.println(list.set(2, "Pear"));
        System.out.println(list);
        System.out.println(list.subList(2, 5));
        System.out.println(list.toArray());
        System.out.println(list.toArray(new String[0]));
        list.remove("Apple");
        System.out.println(list);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Apple");
        list2.add("Banana");
        System.out.println(list.containsAll(list2));
        System.out.println(list.addAll(list2));
        System.out.println(list);
        System.out.println(list.addAll(2, list2));
        System.out.println(list);
        System.out.println(list.retainAll(list2));// it will remove all the elements which are not present in the list2
        System.out.println(list);
        System.out.println(list.removeAll(list2));// it will remove all the elements which are present in the list2
        System.out.println(list);
        System.out.println(list.removeIf(e -> e.equals("Apple")));// it will remove all the elements which are present in the list2
        System.out.println(list);
        System.out.println(list.stream().distinct().count());// it will remove all the duplicate elements
        System.out.println(list);
        System.out.println(list.stream().sorted().count());// it will sort the list in ascending order
        System.out.println(list);

        list.forEach(System.out::println);// it will print all the elements of the list
        // list.forEach(e -> System.out.println(e));
        System.out.println(list.toString());// it will print all the elements of the list
        System.out.println(list.equals(list2));
        list.clear();
    }
}
