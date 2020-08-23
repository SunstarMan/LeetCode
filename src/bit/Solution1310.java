package bit;

/*1310. 子数组异或查询
有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
并返回一个包含给定查询 queries 所有结果的数组。
输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
输出：[2,7,14,8]
解释：数组中元素的二进制表示形式是：1 = 0001       3 = 0011    4 = 0100       8 = 1000
查询的 XOR 值为：
[0,1] = 1 xor 3 = 2
[1,2] = 3 xor 4 = 7
[0,3] = 1 xor 3 xor 4 xor 8 = 14
[3,3] = 8
提示：1 <= arr.length <= 3 * 10^4
1 <= arr[i] <= 10^9
1 <= queries.length <= 3 * 10^4
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] < arr.length
 */
public class Solution1310 {
//    时间复杂度n^2
//    public int[] xorQueries(int[] arr, int[][] queries) {
//        int len = queries.length;
//        int[] ans = new int[len];
//
//        for (int i = 0; i < len; i++) {
//            int left=queries[i][0];
//            int right= queries[i][1];
//            for (int j = left; j <= right; j++) {
//                ans[i]=ans[i]^arr[j];
//            }
//        }
//        return ans;
//    }


    //利用a^a=0;0^a=a
  public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] temp = new int[len];
        temp[0] = arr[0];
        for (int i = 1; i < len; i++) {
            temp[i] = temp[i - 1] ^ arr[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0]>0){
                ans[i] = temp[queries[i][1]] ^ temp[queries[i][0] - 1];
            }else {
                ans[i] = temp[queries[i][1]];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
        int[][] p = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] a = new Solution1310().xorQueries(arr, p);
        for (int i = 0; i < p.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
