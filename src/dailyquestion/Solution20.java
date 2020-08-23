package dailyquestion;

import java.util.Stack;

/*20. 有效的括号-----简单
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:
输入: "([)]"
输出: false
示例 2:
输入: "{[]}"
输出: true
 */
/*
用栈来实现
 */
public class Solution20 {
    public boolean isValid(String s) {
        if (s == null) return true;
        Stack<Character> stack = new Stack<>();
        int len = s.length() - 1;

        for (int i = 0; i <= len; i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty()) {
                if (stack.peek() == '(') {
                    stack.pop();
                } else stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}' && !stack.isEmpty()) {
                if (stack.peek() == '{') {
                    stack.pop();
                } else stack.push(s.charAt(i));
            } else if (s.charAt(i) == ']' && !stack.isEmpty()) {
                if (stack.peek() == '[') {
                    stack.pop();
                } else stack.push(s.charAt(i));
            } else stack.push(s.charAt(i));
        }
        if (stack.isEmpty()) return true;
        else return false;


//        方法二：建立一个新的栈，然后遍历字符串的字符，进行比较
//        Stack<Character> stack = new Stack<Character>();
//        for(char c: s.toCharArray()){
//            if(c=='(')stack.push(')');
//            else if(c=='[')stack.push(']');
//            else if(c=='{')stack.push('}');
//            else if(stack.isEmpty()||c!=stack.pop())return false;
//        }
//        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "}";
        System.out.println(new Solution20().isValid(s1));
    }
}
