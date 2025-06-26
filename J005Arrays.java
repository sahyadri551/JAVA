import java.util.Arrays;

public class J005Arrays {
    public static void main(String[] args) {
        // Declare and initialize an array
        int[] numbers = { 2, 8, 4, 3, 1 };

        // Access elements in the array
        System.out.println("First element: " + numbers[0]);
        System.out.println("Second element: " + numbers[1]);
        System.out.println("Third element: " + numbers[2]);

        // Modify an element in the array
        numbers[2] = 10;
        System.out.println("Modified third element: " + numbers[2]);

        // Get the length of the array
        System.out.println("Array length: " + numbers.length);
        // Iterate through the array
        System.out.print("Array elements: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        //int[] arr = new int[5]; // Declare an array with a size of 5
        int arr2[] = new int[10]; // Declare and initialize an array with a size of 10
        System.out.println("\nArray arr2 length: " + arr2.length);
        arr2[0] = 10; // Assign a value to the first element
        System.out.println("First element of arr2: " + arr2[0]);

        // Multi-dimensional array
        int[][] multiArray = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("\nMulti-dimensional array:");
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                System.out.print(multiArray[i][j] + " ");
            }
            System.out.println();
        }

        int[][] arr3 = new int[2][]; // Declare a 2D array with 2 rows and no specified columns
        System.out.println(arr2);
        System.out.println(arr3);
        System.out.println(arr3[0]); // This will print the reference to the first row of arr3
        arr3[0] = new int[3]; // Initialize the first row with 3 columns
        arr3[1] = new int[4]; // Initialize the second row with 4 columns
        System.out.println(arr3[0]); // Now this will print the reference to the first row of arr3
        System.out.println(arr3[1]); // This will print the reference to the second row

        // Array Methods
        Arrays.sort(numbers); // Sort the array in ascending order
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        int index = Arrays.binarySearch(numbers, 10); // Search for the value 10 in the sorted array
        if (index >= 0) {
            System.out.println("Value 10 found at index: " + index);
        } else {
            System.out.println("Value 10 not found in the array.");
        }
        // Copying arrays
        int[] copiedArray = Arrays.copyOf(numbers, numbers.length); // Create a copy of the array
        System.out.println("Copied array: " + Arrays.toString(copiedArray));
    }

}