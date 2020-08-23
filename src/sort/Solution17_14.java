package sort;

import java.util.Arrays;

/*面试题 17.14. 最小K个数
设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
提示：0 <= len(arr) <= 100000
0 <= k <= min(100000, len(arr))
 */
public class Solution17_14 {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans=new int[k];
        for (int i = 0; i <k ; i++) {
            ans[i]=arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={1,3,5,7,2,4,6,8};
        int k=4;
        int ans[] =new Solution17_14().smallestK(arr,k);
        for (int i = 0; i < k; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
