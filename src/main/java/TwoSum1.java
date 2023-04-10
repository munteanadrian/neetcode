import java.util.HashMap;

public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (values.containsKey(target - nums[i])) {
                return new int[]{i, values.get(target - nums[i])};
            } else {
                values.put(nums[i], i);
            }
        }

        return new int[]{};
    }


    public static void main(String[] args) {

    }
}