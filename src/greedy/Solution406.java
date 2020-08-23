package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*406. 根据身高重建队列
假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
注意：总人数少于1100人。
输入:[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
输出:[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] ans = new int[n][2];
        //身高从高到低，身高相同，k值从少到多
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        for (int i = 0; i < n; i++) {
            int position = people[i][1];
            if (ans[position][0] == 0) {
                ans[position][0] = people[i][0];
                ans[position][1] = people[i][1];
            } else {
                for (int j = n - 1; j > position; j--) {
                    ans[j][0] = ans[j - 1][0];
                    ans[j][1] = ans[j - 1][1];
                }
                ans[position][0] = people[i][0];
                ans[position][1] = people[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = new Solution406().reconstructQueue(a);
        for (int[] ints : queue) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
