public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] list) {
        if (list.length == 1 || list[list.length - 1] > list[0]) {
            return list[0];
        }

        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list[mid] > list[mid + 1]) {
                return list[mid + 1];
            }

            if (list[mid] < list[mid - 1]) {
                return list[mid];
            }

            if (list[mid] > list[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] list = new int[]{3, 4, 5, 1, 2};
        int[] list2 = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] list3 = new int[]{11, 13, 15, 17};
        int[] list4 = new int[]{2, 3, 4, 5, 1};
        int[] list5 = new int[]{3, 1, 2};
        int[] list6 = new int[]{2, 1};

        System.out.println(findMin(list));
        System.out.println(findMin(list2));
        System.out.println(findMin(list3));
        System.out.println(findMin(list4));
        System.out.println(findMin(list5));
        System.out.println(findMin(list6));
    }
}
