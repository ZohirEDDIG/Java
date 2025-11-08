public class Binary {
    public static int binarySearch(int[] nums, int t) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            int middleValue = nums[middleIndex];

            if (t > middleValue) {
                leftIndex = middleIndex + 1;
            } else if (t < middleValue) {
                rightIndex = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int t = 19;

        int index = binarySearch(nums, t);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}