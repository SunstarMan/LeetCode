package heap;

import java.util.*;

/*347. 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
说明：
你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer>  queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2)-map.get(o1);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(queue.poll());
            if (set.contains(queue.peek())) i--;
        }

        Object[] temp=set.toArray();
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = (int)temp[i];//将Object对象数组转为整型数组（强制向下转型）
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        int k=2;
        int[] ans=new Solution347().topKFrequent(nums,k);
        for (int i = 0; i < k; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
