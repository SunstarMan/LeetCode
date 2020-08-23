package dailyquestion;

/*504. 七进制数
给定一个整数，将其转化为7进制，并以字符串形式输出。
示例 :
输入: 100
输出: "202"
注意: 输入范围是 [-1e7, 1e7] 。
 */
/*
迭代除7取余，存到一个StringBuilder里，然后反转；对于负数，直接先取正处理，然后加上负号。
 */
public class Solution504 {
    public String convertToBase7(int num) {
        if (num==0) return "0";
        String ans = "";
        if (num < 0) {
            num = 0 - num;
            ans += "-";
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int mod = num % 7;
            sb.append((char) ('0' + mod));
            num = num / 7;
        }
        ans += sb.reverse().toString();
        return ans;
    }

    public static void main(String[] args) {
        int num=100;
        System.out.println(new Solution504().convertToBase7(num));
    }
}
