public class TwoSumIIInputArrayIsSorted {

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j <= numbers.length; j--) {
                res = numbers[i] + numbers[j] == target ? new int[]{i + 1, j + 1} : new int[2];
                if (res.length != 0) {
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
