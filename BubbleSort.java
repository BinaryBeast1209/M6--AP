import java.util.Scanner;

public class BubbleSort {

    public static void sort(int[] numbers) {
        int length = numbers.length;
        
        for (int pass = 0; pass < length - 1; pass++) {
            boolean hasSwapped = false;

            for (int idx = 0; idx < length - pass - 1; idx++) {
                if (numbers[idx] > numbers[idx + 1]) {
                    int temp = numbers[idx];
                    numbers[idx] = numbers[idx + 1];
                    numbers[idx + 1] = temp;
                    hasSwapped = true;
                }
            }

            if (!hasSwapped) {
                break;
            }
        }
    }

    public static void display(int[] numbers) {
        for (int val : numbers) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int totalElements = scanner.nextInt();

        int[] inputData = new int[totalElements];
        System.out.println("Enter values to sort:");
        for (int i = 0; i < totalElements; i++) {
            inputData[i] = scanner.nextInt();
        }

        sort(inputData);

        System.out.println("Sorted output:");
        display(inputData);

        scanner.close();
    }
}
