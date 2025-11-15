public class Interpolation {
    public static int interpolationSearch(int[] nums, int t) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex && t >= nums[leftIndex] && t <= nums[rightIndex]) {
            int pos = leftIndex + ((t - nums[leftIndex]) * (rightIndex - leftIndex)) / (nums[rightIndex] - nums[leftIndex]);

            if (t == nums[pos]) {
                return pos;
            } else if (t > nums[pos]) {
                leftIndex = pos + 1;
            } else {
                rightIndex = pos - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int t = 8;

        int index = interpolationSearch(nums, t);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}                  