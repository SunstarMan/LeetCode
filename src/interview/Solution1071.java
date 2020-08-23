package interview;

/*1071. 字符串的最大公因子
对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。str1[i] 和 str2[i] 为大写英文字母
输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"
输入：str1 = "LEET", str2 = "CODE"
输出：""
辗转相除法：gcd(a,b) = gcd(b,a mod b)——>假如需要求 1997 和 615 两个正整数的最大公约数,用欧几里德算法，是这样进行的：
1997 / 615 = 3 (余 152)
615 / 152 = 4(余7)
152 / 7 = 21(余5)
7 / 5 = 1 (余2)
5 / 2 = 2 (余1)
2 / 1 = 2 (余0)
至此，最大公约数为1
以除数和余数反复做除法运算，当余数为 0 时，取当前算式除数为最大公约数，所以就得出了 1997 和 615 的最大公约数 1
int gcd(int m,int n)
{   if(n == 0){
        return m;
    }
    int r = m%n;
    return gcd(n,r)
}
 */
public class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        int len1=str1.length();
        int len2=str2.length();
        if (len1>len2){
            if (str1.contains(str2)){//str1.indexOf(str2)!=-1也可以表示
                return gcd(str1,str2);
            }else {
                return "";
            }
        }else {
            if (str2.contains(str1)){
                return gcd(str2,str1);
            }
            else {
                return "";
            }
        }
    }

    public String gcd(String s1,String s2){
        if (s2==null) return s1;
        if (s1.contains(s2)){
            String temp=s1.replaceAll(s2, "");//两字符串相减
            return gcd(s2,temp);
        }else {
            return "";
        }
    }

    public static void main(String[] args) {
        String x="ABCABC";
        String y="ABC";
        System.out.println(new Solution1071().gcdOfStrings(x,y));
    }

}
