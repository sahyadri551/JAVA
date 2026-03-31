void main(){
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);

    Optional<Integer> op1 = list.stream()
            .reduce(Integer::sum);
    op1.ifPresent(System.out::println);

    Optional<Integer> op2 = list.stream()
            .filter(e -> e>10)
            .reduce(Integer::sum);
    op2.ifPresent(System.out::println);
    System.out.println(op2.orElse(-1));
}