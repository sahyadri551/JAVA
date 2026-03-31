void main(){
    List<Integer> l1 = new ArrayList<>();
    l1.add(1);
    l1.add(2);
    l1.add(3);
    l1.add(4);
    l1.add(5);
    l1.add(6);
    l1.add(7);
    l1.add(8);
    l1.add(9);

    //max
    int max = l1.stream().max(Integer::compareTo).get();
    System.out.println(max);

    //min
    int min = l1.stream().min(Integer::compareTo).get();
    System.out.println(min);

    //collect
    List<Integer> l2 = l1.stream()
            .filter(x -> x % 2 == 0)
            .collect(Collectors.toList());
    System.out.println(l2);
}