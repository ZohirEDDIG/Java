import java.util.ArrayList;
import java.util.Arrays;

public class Quick {

    public static int[] quickSort (int[] nums) {
        if (nums.length < 2) return nums;

        int pivot = nums[nums.length - 1];
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < pivot) {
                left.add(nums[i]);
            } else {
                right.add(nums[i]);
            }
        }

        int[] leftSorted = quickSort(arrayListToArray(left));
        int[] rightSorted = quickSort(arrayListToArray(right));

        int[] numsSorted = new int[leftSorted.length + 1 + rightSorted.length];
        System.arraycopy(leftSorted, 0, numsSorted, 0, leftSorted.length);
        numsSorted[leftSorted.length] = pivot;
        System.arraycopy(rightSorted, 0, numsSorted, leftSorted.length + 1, rightSorted.length);

        return numsSorted;
    }


    private static int[] arrayListToArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] numsSorted = quickSort(new int[] {8, 20, -2, 4, -6});

        System.out.println(Arrays.toString(numsSorted));
    }
}