void main(){
    List<Integer> l1 = new ArrayList<>();
    l1.add(7);
    l1.add(2);
    l1.add(3);
    l1.add(4);
    l1.add(4);
    l1.add(3);
    l1.add(6);
    l1.add(5);
    l1.add(9);
    l1.add(1);
    l1.add(8);

    l1.stream().distinct()
            .forEach(System.out::println);
    System.out.println("------------------------");
    l1.stream().sorted()
            .forEach(System.out::println);
    System.out.println("------------------------");
    l1.stream().map(x -> x*x)
            .forEach(System.out::println);
}