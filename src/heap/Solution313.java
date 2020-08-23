package heap;

import java.util.*;

/*313. 超级丑数
编写一段程序来查找第 n 个超级丑数。
超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
输入: n = 12, primes = [2,7,13,19]
输出: 32
解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32]
说明：
1 是任何给定 primes 的超级丑数。
给定 primes 中的数字以升序排列。
0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
第 n 个超级丑数确保在 32 位有符整数范围内。
 */
public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len=primes.length;
        int[] indexes=new int[len];
        List<Integer> list=new ArrayList<>();
        list.add(1);
        Set<Integer> set=new HashSet<>();
        set.add(1);
        int min,temp,indexAdd;

        for (int i = 0; i < n-1; i++) {
            min=primes[0]*list.get(indexes[0]);
            indexAdd=0;
            for (int j = 1; j < len; j++) {
                temp = primes[j]*list.get(indexes[j]);
               if (temp<min) {
                   min=temp;
                   indexAdd=j;
               }
            }
            indexes[indexAdd]++;
            if (set.contains(min)) {
                i--;
            } else {
                list.add(min);
                set.add(min);
            }
        }
        return list.get(n-1);
    }

    public static void main(String[] args) {
        int n=12;
        int[] num={2,7,13,19};
        System.out.println(new Solution313().nthSuperUglyNumber(n,num));
    }
}
