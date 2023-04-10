import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int start = 0;
        int finish = nums.length;
        int i = (start + finish / 2);

        while (start < finish) {
            if (nums[i] == target) {
                return i;
            } else {
                if(nums[i] < target) {
                    start = i + 1;
                } else {
                    finish = i - 1;
                }

                i = (start + finish) / 2;
            }
        }

        System.gc();
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
