package dailyquestion;

import java.util.ArrayList;
import java.util.List;

/*763. 划分字母区间
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
示例 ：
输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
提示：
S的长度在[1, 500]之间。
S只包含小写字母 'a' 到 'z' 。
 */
public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, temp = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - temp + 1);
                temp = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="ababcbacadefegdehijhklij";
        List<Integer> ans=new Solution763().partitionLabels(s);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
