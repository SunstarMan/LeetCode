package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*1341. 方阵中战斗力最弱的 K 行
给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 0 和 1 表示。
请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 */
public class Solution1341 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] answer = new int[k];
        int[] sum = new int[m];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i] += mat[i][j];
            }
        }
        for (int h = 0; h < m; h++) {
            list.add(sum[h]);
        }
        Arrays.sort(sum);
        for (int i = 0; i < k; i++) {
            answer[i] = list.indexOf(sum[i]);
            list.set(answer[i],-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        System.out.println(Arrays.toString(new Solution1341().kWeakestRows(x, 3)));
    }
}
