package sort;

import java.util.Arrays;

/*164. 最大间距
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
如果数组元素个数小于 2，则返回 0。
输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
说明:你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
public class Solution164 {
    public int maximumGap(int[] nums) {
        if (nums.length<2) return 0;
        else {
            Arrays.sort(nums);
            int maxSpace = nums[1] - nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                int temp = ((nums[i + 1]) - nums[i]);
                if (temp > maxSpace) maxSpace = temp;
            }
            return maxSpace;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 9};
        System.out.println(new Solution164().maximumGap(a));
    }
}
