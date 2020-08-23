package binarySearch;

/*50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Solution50 {
    public double myPow(double x, int n) {
        /*if (n == 0) return 1;
        double[] a = new double[Math.abs(n)];
        for (int i = 0; i < n; i++) {
            a[i]=x;
        }
        if (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                double carry = 0;
                while (a[i] != 0) {
                    if (a[i] % 2 != 0) {
                        carry += a[i + 1];
                        a[i] -= 1;
                    }
                    a[i] /= 2;
                    a[i + 1] *= 2;
                }
                a[i+1]=carry;
            }
            return a[n-1];
        } else {
            int m = -n;
            for (int j = 0; j < m - 1; j++) {
                double carry = 0;
                while (a[j] != 0) {
                    if (a[j] % 2 != 0) {
                        carry += a[j + 1];
                        a[j] -= 1;
                    }
                    a[j] /= 2;
                    a[j + 1] *= 2;
                }
                a[j+1]=carry;
            }
            return 1/a[m-1];
        }*/
        double ans = 1.0;
        for (int i = n; i != 0; i = i / 2) {
            if (i % 2 != 0) {
                ans = ans * x;
            }
            x = x * x;
        }
        if (n < 0) return 1 / ans;
        else return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution50().myPow(2.1, 3));
    }
}
