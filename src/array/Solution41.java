package array;

import java.util.ArrayList;
import java.util.List;

/*41. 缺失的第一个正数
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数
输入: [1,2,0]
输出: 3
输入: [3,4,-1,1]
输出: 2
输入: [7,8,9,11,12]
输出: 1
提示：你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        if (len==0) return 1;
        else if (len==1&&nums[0]!=1) return 1;
        else if (len==1) return 2;
        else {
            int min=1;
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(nums[i]);
            }

            for (int i = 0; i < len; i++) {
                if (list.contains(min)){
                    min++;
                }
            }
            return min;
        }

    }

    public static void main(String[] args) {
        int[] a={2,1};
        System.out.println(new Solution41().firstMissingPositive(a));
    }
}
