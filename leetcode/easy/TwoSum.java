import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];

            if (seen.containsKey(compliment)) {
                int [] result = { seen.get(compliment), i };
                return result;
            } else {
                seen.put(nums[i], i);
            }
        }
        
        return null;
    }

    public static void main(String args[]) {
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9)); // { 0, 1}
        System.out.println(twoSum(new int[]{3, 2, 4}, 6)); // { 1, 2}
        System.out.println(twoSum(new int[]{3, 3}, 6)); // { 0, 1 }
    }
}