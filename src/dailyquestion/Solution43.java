package dailyquestion;

/*43. 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
示例 :
输入: num1 = "2", num2 = "3"
输出: "6"
说明：
num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Solution43 {
    public String solve(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String ans = "0";
        int len1 = num1.length();
        int len2 = num2.length();
        for (int i = len2 - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int add = 0;
            for (int j = len2 - 1; j > i; j--) {
                sb.append(0);
            }
            int temp1 = num2.charAt(i) - '0';
            for (int j = len1 - 1; j >= 0; j--) {
                int temp2 = num1.charAt(j) - '0';
                int m = temp1 * temp2 + add;
                sb.append(m % 10);
                add = m / 10;
            }
            if (add != 0) {
                sb.append(add % 10);
            }
            ans = solve(ans, sb.reverse().toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String ans = new Solution43().multiply(num1, num2);
        System.out.println(ans);
    }
}
