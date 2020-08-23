package greedy;

import java.util.Arrays;

/*1433. 检查一个字符串是否可以打破另一个字符串
给你两个字符串 s1 和 s2 ，它们长度相等，
请你检查是否存在一个 s1  的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 的一个排列。
字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序）。
输入：s1 = "abc", s2 = "xya"
输出：true
解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
提示：s1.length == n
s2.length == n
1 <= n <= 10^5
所有字符串都只包含小写英文字母。
 */
public class Solution1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        int len = s1.length();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        boolean flag1 = true;
        for (int i = 0; i < len; i++) {
            if (ch1[i] < ch2[i]) {
                flag1 = false;
                break;
            }
        }
        boolean flag2 = true;
        for (int i = 0; i < len; i++) {
            if (ch2[i] < ch1[i]) {
                flag2 = false;
                break;
            }
        }
        return flag1 | flag2;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "xya";
        System.out.println(new Solution1433().checkIfCanBreak(s1, s2));
    }
}
