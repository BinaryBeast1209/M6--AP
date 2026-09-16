import java.util.Scanner;

public class SelectPosition {

    public static int[] getSortedPositions(int[] arr) {
        int n = arr.length;
        int[] positions = new int[n];

        for (int i = 0; i < n; i++) {
            int targetIndex = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) {
                    targetIndex++;
                }
            }
            positions[i] = targetIndex;
        }

        return positions;
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the unique elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] sortedPositions = getSortedPositions(arr);

        System.out.println("\nOriginal Array:");
        printArray(arr);

        System.out.println("Positions in sorted array:");
        printArray(sortedPositions);

        scanner.close();
    }
}
