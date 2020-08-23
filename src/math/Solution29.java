package math;

/*29. 两数相除
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean neg;
        neg = (dividend ^ divisor) < 0;         //用异或来计算是否符号相异
        long edAbs = Math.abs((long) dividend); //Math.abs绝对值函数
        long orAbs = Math.abs((long) divisor);
        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            if ((edAbs >> i) >= orAbs) {     //找出足够大的数2^n*divisor
                ans = ans + (1 << i);        //将结果加上2^n
                edAbs = edAbs - (orAbs << i);//将被除数减去2^n个divisor
            }
        }
        if (neg==true) return -ans;         //符号相异取反
        else return ans;
    }
}
