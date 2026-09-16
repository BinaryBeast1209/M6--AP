import java.util.Scanner;

public class ReversePairsMergeSort {

    private static int mergeAndCount(long[] numbers, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && numbers[i] > 2 * numbers[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        long[] tempLeft = new long[leftSize];
        long[] tempRight = new long[rightSize];

        for (int i = 0; i < leftSize; i++) {
            tempLeft[i] = numbers[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            tempRight[i] = numbers[mid + 1 + i];
        }

        int i = 0;
        j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (tempLeft[i] <= tempRight[j]) {
                numbers[k++] = tempLeft[i++];
            } else {
                numbers[k++] = tempRight[j++];
            }
        }

        while (i < leftSize) {
            numbers[k++] = tempLeft[i++];
        }

        while (j < rightSize) {
            numbers[k++] = tempRight[j++];
        }

        return count;
    }

    public static int sortAndCount(long[] numbers, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = 0;

        count += sortAndCount(numbers, left, mid);
        count += sortAndCount(numbers, mid + 1, right);
        count += mergeAndCount(numbers, left, mid, right);

        return count;
    }

    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long[] longNums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            longNums[i] = nums[i];
        }

        return sortAndCount(longNums, 0, longNums.length - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int totalReversePairs = reversePairs(nums);

        System.out.println("\nNumber of reverse pairs: " + totalReversePairs);

        scanner.close();
    }
}
