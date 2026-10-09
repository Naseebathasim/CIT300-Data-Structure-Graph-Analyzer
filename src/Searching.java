import java.util.Arrays;

public class Searching {

    public static int linearSearch(int[] array, int target) {

        int steps = 0;

        for (int i = 0; i < array.length; i++) {
            steps++;

            if (array[i] == target) {
                System.out.println("Linear Search: Value found at index " + i);
                System.out.println("Steps: " + steps);
                return steps;
            }
        }

        System.out.println("Linear Search: Value not found.");
        System.out.println("Steps: " + steps);

        return steps;
    }

    public static int binarySearch(int[] array, int target) {

        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);

        int left = 0;
        int right = sortedArray.length - 1;
        int steps = 0;

        while (left <= right) {

            steps++;

            int middle = (left + right) / 2;

            if (sortedArray[middle] == target) {
                System.out.println(
                        "Binary Search: Value found at sorted index " + middle
                );
                System.out.println("Steps: " + steps);
                return steps;
            }

            if (sortedArray[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.println("Binary Search: Value not found.");
        System.out.println("Steps: " + steps);

        return steps;
    }

    public static void displaySortedArray(int[] array) {

        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);

        System.out.print("Sorted Array: ");

        for (int value : sortedArray) {
            System.out.print(value + " ");
        }

        System.out.println();
    }
}