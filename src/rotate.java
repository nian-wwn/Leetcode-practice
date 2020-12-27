/**
 * title 48.旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 */
public class rotate {
    public void rotate1(int[][] matrix) {
        int[][] matrix1 = new int[matrix.length][matrix.length];
        int len = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix1[i][j] = matrix[j][matrix.length - i - 1];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = matrix1[i][j];
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int len = matrix.length;
        int temp = 0;

        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < (len + 1) / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = temp;
            }
        }
    }
}
