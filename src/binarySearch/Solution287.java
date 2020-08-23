package binarySearch;

import java.util.Arrays;

/*287. 寻找重复数
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {
        /*HashSet解题
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.add(num)==false){
                return num;
            }
        }
        return -1;*/

        /*二分查找*/
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 1 && (nums[mid] == nums[mid - 1] || nums[mid] == nums[mid + 1])) {
                return nums[mid];
            } else if (mid == 1) {
                return nums[mid];
            } else if (nums[mid] <= mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
}

    public static void main(String[] args) {
        int[] x = {1, 3, 4, 2, 2};
        System.out.println(new Solution287().findDuplicate(x));
    }
}