package dailyquestion;

/*415. 字符串相加
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
注意：num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

******方法一：模拟
思路与算法
本题我们只需要对两个大整数模拟「竖式加法」的过程。
竖式加法就是我们平常学习生活中常用的对两个整数相加的方法，回想一下我们在纸上对两个整数相加的操作，
是将相同数位对齐，从低到高逐位相加，如果当前位和超过 1010，则向高位进一位.
定义两个指针 ii 和 jj 分别指向 num1 和 num2 的末尾，即最低位，
同时定义一个变量add 维护当前是否有进位，然后从末尾到开头逐位相加即可.
两个数字位数不同怎么处理，这里我们统一在指针当前下标处于负数的时候返回 0，
等价于对位数较短的数字进行了补零操作，这样就可以除去两个数字位数不同情况的处理
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x, y;
            if (i >= 0) {
                x = num1.charAt(i) - '0';
            } else {
                x = 0;
            }
            if (j >= 0) {
                y = num2.charAt(j)-'0';
            } else {
                y = 0;
            }
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String num1="234";
        String num2="2567";
        System.out.println(new Solution415().addStrings(num1,num2));
    }
}
