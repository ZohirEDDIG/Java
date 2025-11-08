public class Linear {
    // Time complexity: O(n)
    public static int linearSearch(int[] nums, int t) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == t) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        int t = 10;

        int index = linearSearch(nums, t);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
        
    }
}