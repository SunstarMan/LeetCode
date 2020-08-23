package greedy;

import java.util.*;

/*1400. 构造 K 个回文字符串
给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。
如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。
输入：s = "annabelle", k = 2
输出：true
解释：可以用 s 中所有字符构造 2 个回文字符串。
一些可行的构造方案包括："anna" + "elble"，"anbna" + "elle"，"anellena" + "b"
提示：1 <= s.length <= 10^5
s 中所有字符都是小写英文字母。
1 <= k <= 10^5
 */
public class Solution1400 {
    public boolean canConstruct(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        if (k == s.length()) return true;
        else if (k > s.length()) return false;
        else {
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            int odd=0;
            Set<Character> keySet = map.keySet();
            for (Character character : keySet) {
                Integer integer = map.get(character);
                if (integer %2 == 1) odd +=1;
            }

            if (odd>k) return false;
            else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        String s="annabelle";
        int k=2;
        System.out.println(new Solution1400().canConstruct(s,k));
    }
}
