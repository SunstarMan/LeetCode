package binarySearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*33. 搜索旋转排序数组
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。
 */
public class Solution33 {
    public static class arr{
        private int num;
        private int index;

        public arr(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public int search(int[] nums, int target) {
        List<arr> arrList=new ArrayList<>();
        int ans;
        for (int i=0;i<nums.length;i++){
            arrList.add(new arr(nums[i],i));
        }

        arrList.sort(new Comparator<arr>() {
            @Override
            public int compare(arr o1, arr o2) {
                return o1.num-o2.num;
            }
        });

        for (arr arr : arrList) {
            if (arr.num==target) return arr.index;
        }
        return -1;
    }
}
