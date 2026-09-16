import java.util.Scanner;

public class QuickSort {

    private static void swapElements(int[] numbers, int firstIndex, int secondIndex) {
        int temp = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temp;
    }

    private static int partitionArray(int[] numbers, int start, int end) {
        int pivotValue = numbers[end];
        int boundary = start - 1;

        for (int idx = start; idx < end; idx++) {
            if (numbers[idx] < pivotValue) {
                boundary++;
                swapElements(numbers, boundary, idx);
            }
        }

        swapElements(numbers, boundary + 1, end);
        return boundary + 1;
    }

    public static void sort(int[] numbers, int start, int end) {
        if (start < end) {
            int pivotIndex = partitionArray(numbers, start, end);

            sort(numbers, start, pivotIndex - 1);
            sort(numbers, pivotIndex + 1, end);
        }
    }

    public static void displayArray(int[] numbers) {
        for (int value : numbers) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int totalElements = inputScanner.nextInt();

        int[] values = new int[totalElements];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < totalElements; i++) {
            values[i] = inputScanner.nextInt();
        }

        sort(values, 0, totalElements - 1);

        System.out.println("Sorted array:");
        displayArray(values);

        inputScanner.close();
    }
}
