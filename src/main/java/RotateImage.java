import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        // 1. Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. Flip horizontally
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(m1);
        System.out.println(Arrays.deepToString(m1));
    }
}
