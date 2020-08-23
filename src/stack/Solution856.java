package stack;

import java.util.Stack;

/*856. 括号的分数
给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
() 得 1 分。
AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
(A) 得 2 * A 分，其中 A 是平衡括号字符串。
示例 1：
输入： "()"
输出： 1

示例 2：
输入： "(())"
输出： 2
 */
public class Solution856 {
    public int scoreOfParentheses(String S) {
        int ans = 0;
        int length = S.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char temp = S.charAt(i);
            if (temp == '(')
                stack.add(temp);
            else {
                if (S.charAt(i - 1) == '(') {
                    ans += Math.pow(2, stack.size() - 1);
                    stack.pop();
                } else {
                    stack.pop();
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "(())";
        int ans = new Solution856().scoreOfParentheses(s);
        System.out.println(ans);
    }
}
