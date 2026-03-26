package com.CollectionsLib;
import java.util.Vector;

public class J033Vector {
    static void main() {
        Vector<String> v = new Vector<>();
        v.add("Apple");
        v.add("Banana");
        v.add("Orange");
        v.add("Mango");
        v.add("Pineapple");
        System.out.println(v);
        v.remove(2);
        System.out.println(v);
        System.out.println(v.get(2));
        System.out.println(v.size());
        System.out.println(v.isEmpty());
        System.out.println(v.contains("Apple"));
        System.out.println(v.indexOf("Apple"));
        System.out.println(v.lastIndexOf("Apple"));
        System.out.println(v.set(2, "Pear"));
        System.out.println(v);
        System.out.println(v.subList(2, v.size()));
        System.out.println(v.toArray());
        System.out.println(v.toArray(new String[0]));
        System.out.println(v.toString());
        Vector<String> v2 = new Vector<>();
        v2.addAll(v); // equivalent to Vector<String> v2 = new Vector<>(v);
        v2.addAll(2, v);
        v2.retainAll(v);

        v2.removeIf(e -> e.equals("Apple"));
        System.out.println(v2);
        v.forEach(System.out::println);
        System.out.println(v2.stream().distinct().count());
        System.out.println(v2.stream().sorted().count());
        System.out.println(v2.equals(v));
        System.out.println(v.containsAll(v2));
        System.out.println(v.elements().nextElement());// it will return the first element of the vector
        System.out.println(v.firstElement());// it will return the first element of the vector
        System.out.println(v.lastElement());// it will return the last element of the vector
        System.out.println(v2.removeAll(v));
        v2.clear();
        System.out.println(v2);
    }
}
