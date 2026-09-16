import java.util.Scanner;

public class SelectionSort {

    public static void performSort(int[] items) {
        int count = items.length;

        for (int i = 0; i < count - 1; i++) {
            int smallestIndex = i;

            for (int j = i + 1; j < count; j++) {
                if (items[j] < items[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            int swapValue = items[smallestIndex];
            items[smallestIndex] = items[i];
            items[i] = swapValue;
        }
    }

    public static void printList(int[] items) {
        for (int element : items) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int total = input.nextInt();

        int[] numbers = new int[total];

        System.out.println("Enter the elements:");
        for (int i = 0; i < total; i++) {
            numbers[i] = input.nextInt();
        }

        performSort(numbers);

        System.out.println("Sorted array:");
        printList(numbers);

        input.close();
    }
}
