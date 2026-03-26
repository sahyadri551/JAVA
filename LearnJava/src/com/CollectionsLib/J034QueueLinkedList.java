package com.CollectionsLib;
import java.util.LinkedList;
import java.util.Queue;

public class J034QueueLinkedList {
    static void main() {
        Queue<String> q = new LinkedList<>();
        q.add("Apple");
        q.add("Banana");
        q.add("Orange");
        q.add("Mango");
        q.add("Pineapple");
        System.out.println(q);
        System.out.println(q.peek());// it will return the first element of the queue without removing it
        System.out.println(q.poll());// it will return the first element of the queue and remove it
        System.out.println(q);
        System.out.println(q.element());// it will return the first element of the queue
        q.offer("Grapes");
        System.out.println(q);
        System.out.println(q.remove());// it will return the first element of the queue and remove it
        System.out.println(q);
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.contains("Apple"));
        System.out.println(q.contains("Grapes"));
        System.out.println(q.toString());
        System.out.println(q.toArray());
        Queue<String> q2 = new LinkedList<>();
        q2.add("Apple");
        q2.add("Banana");
        q2.add("Orange");
        q2.add("Mango");
        q2.add("Pineapple");
        Utility.print(q2);
        System.out.println(q2.equals(q));
        System.out.println(q2.containsAll(q));
        System.out.println(q2.addAll(q));
        q.addAll(q2);
        System.out.println(q.stream().distinct().count());
        System.out.println(q.stream().sorted().count());
        q.forEach(System.out::println);
        System.out.println(q2.removeIf(e -> e.equals("Apple")));
        System.out.println(q2);
        System.out.println(q2.retainAll(q));// it will remove all the elements which are not present in the list2
        System.out.println(q2.removeAll(q));
        System.out.println(q2);
        q2.clear();
    }
}
