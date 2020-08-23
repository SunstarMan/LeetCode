package dailyquestion;

import java.util.*;

/*1163. 按字典序排在最后的子串------困难
给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
示例 1：
输入："abab"
输出："bab"
解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
示例 2：
输入："leetcode"
输出："tcode"
提示：
1 <= s.length <= 4 * 10^5
s 仅含有小写英文字符。
 */
public class Solution1163 {
    public String lastSubstring(String s) {
//        int len = s.length();
//        boolean flag = true;
//        if (len == 0) {
//            return s;
//        } else {
//            for (int i = 0; i < len; i++) {
//                if (s.charAt(i) != s.charAt(0)) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) return s;
//        }
//        int indexMaxLetter = 0;
//        char maxLetter = s.charAt(0);
//        for (int i = 0; i < len; i++) {
//            if (s.charAt(i) >= maxLetter) {
//                maxLetter = s.charAt(i);
//                indexMaxLetter = i;
//            }
//        }
//        String ans = s.substring(indexMaxLetter, len);
//        String temp;
//        for (int i = indexMaxLetter - 1; i >= 0; i--) {
//            if (s.charAt(i) == maxLetter) {
//                temp = s.substring(i, len);
//                if (temp.compareTo(ans) > 0) {
//                    ans = temp;
//                }
//            }
//        }
////        public String substring(int beginIndex, int endIndex),beginIndex:起始索引（包括）;endIndex:结束索引（不包括）
//        return ans;

        int len = s.length();
        char maxChar = 'a';
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) > maxChar)
                maxChar = s.charAt(i);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.naturalOrder());
        queue.offer(s);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != maxChar) continue;
            int length = 1;
            while ((i + length - 1 < len) && s.charAt(i + length - 1) == maxChar) length += 1;
            queue.offer(s.substring(i));
            queue.poll();
            i += length - 1;
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        String s = "cacacb";
        String ans = new Solution1163().lastSubstring(s);
        System.out.println(ans);
    }
}


