package binarySearch;

/*35:搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        /*思路1
        List<Integer> list=new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        if (!list.contains(target)){
            list.add(target);
            Collections.sort(list);
            return list.indexOf(target);
        }else {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }*/

        //思路2
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (left > right) {
                return left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 7, 9};
        System.out.println(new Solution35().searchInsert(x, 6));
    }
}
