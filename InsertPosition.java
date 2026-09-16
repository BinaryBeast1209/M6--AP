import java.util.Scanner;

public class InsertPosition {

    public static int[] getTargetPositions(int[] elements) {
        int length = elements.length;
        int[] targetPositions = new int[length];

        for (int i = 0; i < length; i++) {
            int smallerCount = 0;
            for (int j = 0; j < length; j++) {
                if (elements[j] < elements[i]) {
                    smallerCount++;
                }
            }
            targetPositions[i] = smallerCount;
        }

        return targetPositions;
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int total = scanner.nextInt();

        int[] numbers = new int[total];
        System.out.println("Enter the elements:");
        for (int i = 0; i < total; i++) {
            numbers[i] = scanner.nextInt();
        }

        int[] positions = getTargetPositions(numbers);

        System.out.println("\nTarget positions in sorted array:");
        printArray(positions);

        scanner.close();
    }
}
