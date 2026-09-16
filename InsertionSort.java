import java.util.Scanner;

public class InsertionSort {

    public static void executeSort(int[] elements) {
        int length = elements.length;

        for (int index = 1; index < length; index++) {
            int current = elements[index];
            int prevIndex = index - 1;

            while (prevIndex >= 0 && elements[prevIndex] > current) {
                elements[prevIndex + 1] = elements[prevIndex];
                prevIndex--;
            }
            elements[prevIndex + 1] = current;
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int size = consoleScanner.nextInt();

        int[] data = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            data[i] = consoleScanner.nextInt();
        }

        executeSort(data);

        System.out.println("Sorted array:");
        printArray(data);

        consoleScanner.close();
    }
}
