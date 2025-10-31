public class Linear {

    public static boolean linearSearch(int[] nums, int t) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == t) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        boolean isTenExistsInNums = linearSearch(new int[] {10, 20, 30, 40, 50}, 10);
        boolean isOneHundredInNums = linearSearch(new int[] {10, 20, 30, 40, 50}, 100);
        System.out.println(isTenExistsInNums);
        System.out.println(isOneHundredInNums);
        
    }
}