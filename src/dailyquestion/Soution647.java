package dailyquestion;

/*647. 回文子串
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
提示：
输入的字符串长度不会超过 1000 。
 */
public class Soution647 {
    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int res = 0;
        int length = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < length; i++) {
            res += countPalindrome(chars, i, i);
            res += countPalindrome(chars, i, i + 1);
        }

        return res;
    }

    private int countPalindrome(char[] chars, int start, int end) {
        int curRes = 0;
        int length = chars.length;
        while ((start >= 0) && (end < length) && (chars[start--] == chars[end++])) {
            curRes++;
        }

        return curRes;
    }

    public static void main(String[] args) {
        String s = "aaa";
        int ans = new Soution647().countSubstrings(s);
        System.out.println(ans);
    }
}
