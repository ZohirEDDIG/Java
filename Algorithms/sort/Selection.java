import java.util.Arrays;

public class Selection {
    // Time Complexity: O(n^2) - Quadratic
    public static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {8, 20, -2, 4, 6};
        int[] numsSorted = selectionSort(nums);

        System.out.println(Arrays.toString(numsSorted));
    }
}