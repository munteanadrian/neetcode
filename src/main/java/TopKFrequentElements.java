import java.util.HashMap;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> top = new HashMap<>();

        for (int el : nums) {
            top.putIfAbsent(el, 1 + top.getOrDefault(el, 0));
        }

        System.out.println(top.keySet());
        System.out.println(top.values());

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(topKFrequent(nums, k));
    }
}
