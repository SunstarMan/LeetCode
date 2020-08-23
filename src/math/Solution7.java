package math;

/*7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution7 {
    public int reverse(int x) {
        if (x==0) return 0;
        long ansMid;

        String s1=String.valueOf(x);
        StringBuffer aBuffer = new StringBuffer(s1);
        if (aBuffer.charAt(0)=='-') aBuffer.deleteCharAt(0);
        aBuffer.reverse();
        if (aBuffer.charAt(0)=='0') aBuffer.deleteCharAt(0);
        String s2 = aBuffer.toString();
        ansMid= Long.parseLong(s2);
        if (Math.abs(ansMid)>Integer.MAX_VALUE) {
            return 0;
        }else {
            int res=(int) ansMid;
            if (x<0) return 0-res;
            else return res;
        }
    }

    public static void main(String[] args) {
        int x=1534236469;
        System.out.println(new Solution7().reverse(x));
    }
}
