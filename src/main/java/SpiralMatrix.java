import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralMatrix = new ArrayList<>();

        int col = 0;
        int right = matrix[0].length;
        int left = 0;

        int line = 0;
        int top = 0;
        int bottom = matrix.length;

        spiralMatrix.add(matrix[0][0]);

        int added = 1;
        while (added < matrix[0].length * matrix.length) {
            while (col < right - 1 && added < matrix[0].length * matrix.length) {
                col++;
                spiralMatrix.add(matrix[line][col]);
                added++;
            }

            while (line < bottom - 1 && added < matrix[0].length * matrix.length) {
                line++;
                spiralMatrix.add(matrix[line][col]);
                added++;
            }

            while (col > left && added < matrix[0].length * matrix.length) {
                col--;
                spiralMatrix.add(matrix[line][col]);
                added++;
            }

            while (line > top + 1 && added < matrix[0].length * matrix.length) {
                line--;
                spiralMatrix.add(matrix[line][col]);
                added++;
            }

            right--;
            bottom--;
            left++;
            top++;
        }

        return spiralMatrix;
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(m1));
    }

}
