package com.CollectionsLib;
import java.util.Collection;
import java.util.Map;

public class Utility {
    public static <E> void print(Collection<E> obj) {
        for (Object o : obj) {
            System.out.printf("%s ",o.toString());
            System.out.println();
        }
    }
    public static <K, V> void print(Map<K, V> obj) {
        for (Map.Entry<K, V> entry : obj.entrySet()) {
            System.out.printf("%s : %s%n", entry.getKey().toString(), entry.getValue().toString());
        }
    }
}
