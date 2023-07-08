public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int inflexion = -1;

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        // Only look for inflexion point if rotated
        if (nums[nums.length - 1] < nums[0]) {
            // Find inflexion point
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] > nums[mid + 1]) {
                    inflexion = mid + 1;
                    break;
                }

                if (nums[mid - 1] > nums[mid]) {
                    inflexion = mid;
                    break;
                }

                if (nums[mid] < nums[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            low = 0;
            high = nums.length - 1;

            // Find which half the target is in
            if (nums[low] <= target && target <= nums[inflexion - 1]) {
                high = inflexion - 1;
            } else {
                low = inflexion;
            }
        }

        // Binary search in that half
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] list = new int[]{3, 4, 5, 6, 7, 1, 2};

        System.out.println(search(list, 4));
    }
}
