void main(){
    int[] arr= new int[5];
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30;
    arr[3] = 40;
    arr[4] = 50;
//    other ways to declare an array:
//    int[] arr2;
//    int arr3[];
//    arr= new int[]{1, 2, 3, 4, 5};

    int[] arr4 = IntStream.range(1, 6).toArray();
    for(int i = 0; i < arr.length; i++){
        arr[i] = i + 1;
    }

    for(int i : arr4){
        IO.println(i);
    }

    String[] names = {"Alice", "Bob", "Charlie"};
    for(String name : names){
        IO.println(name);
    }

    Arrays.sort(arr4);           // [1,1,3,4,5]
    int index = Arrays.binarySearch(arr, 40);  // 3
    IO.println(index);
    String result = Arrays.toString(arr);     // "[10,20,30,40,50]"
    IO.println(result);
    boolean found = Arrays.equals(arr, new int[]{1,1,3,4,5});  // false
    IO.println(found);
    int[] copy = Arrays.copyOf(arr, 3);       // [10,20,30]
    IO.println(Arrays.toString(copy));

    Arrays.stream(arr).forEach(System.out::println);

}