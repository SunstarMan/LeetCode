package dailyquestion;

import java.util.Arrays;

/*910. 最小差值 II-----中等
给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
在此过程之后，我们得到一些数组 B。
返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
示例 1：
输入：A = [1], K = 0
输出：0
解释：B = [1]
1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000

 */
public class Solution910 {
    public int smallestRangeII(int[] A, int K) {
        int len = A.length - 1;
        Arrays.sort(A);

        int ans = A[len] - A[0];
        for (int i = 0; i < len; ++i) {
            int a = A[i];
            int b = A[i + 1];
            int high = Math.max(A[len] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {4, 7, 4};
        int K = 4;
        int ans = new Solution910().smallestRangeII(A, K);
        System.out.println(ans);
    }
}
