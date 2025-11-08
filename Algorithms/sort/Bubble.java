import java.util.Arrays;

public class Bubble {
    // Bubble Sort
    // Time Complexity: O(n^2) - Quadratic
    public static int[] bubbleSort(int[] nums) {
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {8, 20, -2, 4, 6};
        int[] numsSorted = bubbleSort(nums);

        System.out.println(Arrays.toString(numsSorted));
    }
}