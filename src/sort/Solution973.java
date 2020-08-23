package sort;

import java.util.Arrays;

/*973. 最接近原点的 K 个点
我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
（这里，平面上两点之间的距离是欧几里德距离。）
你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
输入：points = [[1,3],[-2,2]], K = 1
输出：[[-2,2]]
解释： (1, 3) 和原点之间的距离为 sqrt(10)，
(-2, 2) 和原点之间的距离为 sqrt(8)，
由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
提示：1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
 */
public class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        Arrays.sort(points, (o1, o2) -> (Math.abs(o1[0]) + Math.abs(o1[1])) == (Math.abs(o2[0]) + Math.abs(o2[1]))
                ? Math.abs(Math.abs(o1[0]) - Math.abs(o1[1])) - Math.abs(Math.abs(o2[0]) - Math.abs(o2[1]))
                : ((int) Math.pow(o1[0],2) + (int) Math.pow(o1[1],2)) - ((int)Math.pow(o2[0],2) + (int) Math.pow(o2[1],2)));
        for (int i = 0; i < K; i++) {
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {-2, 2}};
        int[][] ans = new int[1][2];
        ans = new Solution973().kClosest(a, 1);
        for (int i = 0; i < 1; i++) {
            System.out.print(ans[i][0] + " " + ans[i][1]);
            System.out.println();
        }
    }
}
