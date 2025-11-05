public class Binary {
    public static boolean binarySearch(int[] nums, int t) {
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
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(nums, 5));
        System.out.println(binarySearch(nums, 8));
    }
}