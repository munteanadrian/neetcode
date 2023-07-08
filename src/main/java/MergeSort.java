import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int fhl = middle - left + 1;
        int shl = right - middle;

        int[] firstHalf = new int[fhl];
        int[] secondHalf = new int[shl];


        System.arraycopy(array, left, firstHalf, 0, fhl);
        System.arraycopy(array, middle + 1, secondHalf, 0, shl);

        int i = 0, j = 0, k = 0;
        while (i < fhl && j < shl) {
            if (firstHalf[i] <= secondHalf[j]) {
                array[k] = firstHalf[i];
                i++;
            } else {
                array[k] = secondHalf[j];
                j++;
            }
            k++;
        }

        while (i < fhl) {
            array[k] = firstHalf[i];
            i++;
            k++;
        }

        while (j < shl) {
            array[k] = secondHalf[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 3, 2};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
