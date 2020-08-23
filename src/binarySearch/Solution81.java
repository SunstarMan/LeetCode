package binarySearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*81. 搜索旋转排序数组 II
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 */
public class Solution81 {
    public static class arr{
        private int num;
        private int index;

        public arr(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public boolean search(int[] nums, int target) {
        List<arr> arrList=new ArrayList<>();
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
            if (arr.num==target) return true;
        }
        return false;
    }
}

