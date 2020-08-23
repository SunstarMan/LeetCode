package dfs;

import java.util.ArrayDeque;
import java.util.Queue;

/*547. 朋友圈(done)
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 */
public class Solution547 {
    public int findCircleNum(int[][] M) {
        int ans = 0;
        int n = M.length;
        for (int i = 0; i < n; i++) {
            if (M[i][i] == 1) {
                M[i][i] = 0;
                ans = ans + 1;
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer person = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (M[person][j] == 1) {
                            queue.add(j);
                            M[person][j] = 0;
                            M[j][person] = 0;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new Solution547().findCircleNum(x));
    }
}
