package dp;
//Dynamic Programming

/*70. 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int step1 = 1;
        int step2 = 2;

        for (int i = 3; i <= n; i++) {
            int temp = step1 + step2;
            step1 = step2;
            step2 = temp;
        }
        return step2;
    }

    public static void main(String[] args) {
        int x=10;
        System.out.println(new Solution70().climbStairs(x));
    }
}
