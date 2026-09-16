import java.util.Scanner;

public class BrokenEconomy {

    public static void findFloorAndCeil(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        int floor = -1;
        int ceil = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ceil = arr[mid];
                floor = arr[mid];
                break;
            } else if (target < arr[mid]) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                floor = arr[mid];
                low = mid + 1;
            }
        }

        System.out.println("Ceil: " + ceil);
        System.out.println("Floor: " + floor);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter target value (d): ");
        int d = scanner.nextInt();

        findFloorAndCeil(arr, d);

        scanner.close();
    }
}
