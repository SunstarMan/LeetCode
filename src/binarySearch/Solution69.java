package binarySearch;

/*69. x 的平方根
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Solution69 {
    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;

        while (left < right) {
            long mid = (left + right + 1) /2;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
       /* if (x == 0 || x == 1) return x;

        long left = 0;
        long right = x / 2 + 1;
        while (left <= right) {
            long mid = (left + right + 1) / 2;
            long temp = mid * mid;
            long tmp = (mid + 1) * (mid + 1);
            if (temp == x || (temp < x && tmp > x)) {
                return (int) mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;*/
    }

    public static void main(String[] args) {
        int x = 5;
        System.out.println(new Solution69().mySqrt(x));
    }
}
