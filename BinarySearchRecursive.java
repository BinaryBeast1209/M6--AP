import java.util.Scanner;

public class BinarySearchRecursive {

    public static int search(int[] numbers, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (numbers[mid] == target) {
            return mid;
        }

        if (numbers[mid] > target) {
            return search(numbers, low, mid - 1, target);
        }

        return search(numbers, mid + 1, high, target);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int count = scanner.nextInt();

        int[] values = new int[count];
        System.out.println("Enter sorted values:");
        for (int i = 0; i < count; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.print("Enter target element: ");
        int target = scanner.nextInt();

        int resultIndex = search(values, 0, count - 1, target);

        if (resultIndex != -1) {
            System.out.println("Element found at index: " + resultIndex);
        } else {
            System.out.println("Element not found in array.");
        }

        scanner.close();
    }
}
