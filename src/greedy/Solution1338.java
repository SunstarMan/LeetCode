package greedy;

import java.util.*;

/*1338. 数组大小减半
给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
返回 至少 能删除数组中的一半整数的整数集合的最小大小。
输入：arr = [3,3,3,3,5,5,5,2,2,7]
输出：2
解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
提示：
1 <= arr.length <= 10^5
arr.length 为偶数
1 <= arr[i] <= 10^5
 */
public class Solution1338 {
    public int minSetSize(int[] arr) {
        int len=arr.length/2;
        int sum=0;
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < len*2; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        //将map转换为list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        for (int i = 0; i < list.size(); i++) {
            if (sum < len) {
                sum += list.get(i).getValue();
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a={7,7,7,7};
        System.out.println(new Solution1338().minSetSize(a));
    }
}
