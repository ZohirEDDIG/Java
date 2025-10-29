import java.util.Arrays;

public class Insertion {

    public static int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int numToInsert = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > numToInsert) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = numToInsert;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] numsSorted = insertionSort(new int[] {8, 20, -2, 4, 6});

        System.out.println(Arrays.toString(numsSorted));

    }
}
