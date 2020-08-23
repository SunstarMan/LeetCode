package array;

/*48. 旋转图像
给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 */
public class Solution48 {
//    public static void swap( int a, int b) {
//        int temp;
//        temp = a;
//        a = b;
//        b = temp;
//    }
//
//    public static void swap2( int[] a, int[] b) {
//        int len=a.length;
//        int[] temp=new int[len];
//        for (int i=0;i<len;i++){
//            temp[i] = a[i];
//            a[i] = b[i];
//            b[i] = temp[i];
//        }
//    }
//
//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        for (int i = 0; i < n / 2; i++) {
//                swap2(matrix[i],(matrix[n - 1 - i]));
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                swap(matrix[i][j], matrix[j][i]);
//            }
//        }
//    }


    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution48().rotate(x);
        for (int[] ints : x) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
