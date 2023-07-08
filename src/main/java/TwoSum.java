import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sol = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (sol.containsKey(target - nums[i])) {
                return new int[]{sol.get(target - nums[i]), i};
            }

            sol.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
