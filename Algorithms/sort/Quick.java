import java.util.Arrays;

public class Quick {
    public static int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivotIndex = partition(nums, leftIndex, rightIndex);
            quickSort(nums, leftIndex, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, rightIndex);
        }
    }

    public static int partition(int[] nums, int leftIndex, int rightIndex) {
        int pivot = nums[rightIndex];
        int pivotIndex = leftIndex - 1;

        for (int j = leftIndex; j < rightIndex; j++) {
            if (nums[j] < pivot) {
                pivotIndex++;

                int temp = nums[pivotIndex];
                nums[pivotIndex] = nums[j];
                nums[j] = temp;
            }
        }

        pivotIndex++;
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[rightIndex];
        nums[rightIndex] = temp;

        return pivotIndex;
    }

    public static void main(String[] args) {
        int[] nums = {8, 20, -2, 4, 6};
        int[] numsSorted = quickSort(nums);
        System.out.println(Arrays.toString(numsSorted));
    }
}