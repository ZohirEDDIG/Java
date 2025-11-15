import java.util.Arrays;

public class Merge {
    public static void mergeSort(int[] nums) {
        int numsLength = nums.length;
        if (numsLength < 2) {
            return;
        }

        int middleIndex = numsLength / 2;

        int[] leftNums = new int[middleIndex];
        int[] rightNums = new int[numsLength - middleIndex];

        for (int i = 0; i < numsLength; i++) {
            if (i < middleIndex) {
                leftNums[i] = nums[i];
            } else {
                rightNums[i - middleIndex] = nums[i];
            }
        }

        mergeSort(leftNums);
        mergeSort(rightNums);

        merge(leftNums, rightNums, nums);
    }

    public static void merge(int[] leftNums, int[] rightNums, int[] nums) {
        int leftLength = leftNums.length;
        int rightLength = rightNums.length;

        int i = 0;
        int l = 0;
        int r = 0; 

        while (l < leftLength && r < rightLength) {
            if (leftNums[l] <= rightNums[r]) {
                nums[i] = leftNums[l];
                i++;
                l++;
            } else {
                nums[i] = rightNums[r];
                i++;
                r++;
            }
        }

        while (l < leftLength) {
            nums[i] = leftNums[l];
            i++;
            l++;
        }

        while (r < rightLength) {
            nums[i] = rightNums[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {8, 20, -2, 4, 6};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}