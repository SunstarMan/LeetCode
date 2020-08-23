package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EventListener;

/*1247. 交换字符使得字符串相同
有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
交换只能发生在两个不同的字符串之间，不能发生在同一个字符串内部。即我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
输入：s1 = "xx", s2 = "yy"
输出：1
解释：交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。
提示：1 <= s1.length, s2.length <= 1000
s1, s2 只包含 'x' 或 'y'。
 */
public class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int len = ch2.length;
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < len; i++) {
            if (ch1[i] != ch2[i] && ch1[i] == 'x') {
                num1++;
            }
            if (ch1[i] != ch2[i] && ch1[i] == 'y') {
                num2++;
            }
        }

        if ((num1 + num2) % 2 != 0) return -1;
        else {
            if (num1 % 2 == 0) return (num1 + num2) / 2;
            else return (num1 + num2) / 2 + 1;
        }
    }

    public static void main(String[] args) {
        String s1 = "xxyyxyxyxx";
        String s2 = "xyyxyxxxyx";
        System.out.println(new Solution1247().minimumSwap(s1, s2));
    }
}
