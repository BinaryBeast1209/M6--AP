import java.util.Arrays;
import java.util.Scanner;

public class AppleEater {

    static class Apple {
        int id;
        int x;
        int y;
        int eatenBefore;

        Apple(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.eatenBefore = 0;
        }
    }

    private static void quickSort(Apple[] apples, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(apples, low, high);
            quickSort(apples, low, pivotIndex - 1);
            quickSort(apples, pivotIndex + 1, high);
        }
    }

    private static int partition(Apple[] apples, int low, int high) {
        Apple pivot = apples[high];
        int boundary = low - 1;

        for (int j = low; j < high; j++) {
            if (compareApples(apples[j], pivot) < 0) {
                boundary++;
                swap(apples, boundary, j);
            }
        }

        swap(apples, boundary + 1, high);
        return boundary + 1;
    }

    private static int compareApples(Apple a1, Apple a2) {
        if (a1.y != a2.y) {
            return Integer.compare(a1.y, a2.y);
        }
        if (a1.y % 2 == 1) {
            return Integer.compare(a1.x, a2.x);
        } else {
            return Integer.compare(a2.x, a1.x);
        }
    }

    private static void swap(Apple[] apples, int i, int j) {
        Apple temp = apples[i];
        apples[i] = apples[j];
        apples[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total apples: ");
        int n = scanner.nextInt();

        Apple[] apples = new Apple[n];
        System.out.println("Enter coordinates (X Y) for each apple:");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            apples[i] = new Apple(i, x, y);
        }

        quickSort(apples, 0, n - 1);

        for (int i = 0; i < n; i++) {
            apples[i].eatenBefore = i;
        }

        Arrays.sort(apples, (a1, a2) -> Integer.compare(a1.id, a2.id));

        System.out.println("\nNumber of apples eaten before each apple:");
        for (int i = 0; i < n; i++) {
            System.out.println("Apple " + (i + 1) + " (ID " + apples[i].id + "): " + apples[i].eatenBefore);
        }

        scanner.close();
    }
}
