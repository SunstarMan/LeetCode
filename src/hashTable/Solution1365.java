package hashTable;

/*有多少少于当前数字的数字
给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。
输入：nums = [8,1,2,2,3]
输出：[4,0,1,1,3]
 */
public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    count[i]++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={8,1,2,2,3};
        int[] count;
        count= new Solution1365().smallerNumbersThanCurrent(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(count[i]+" ");
        }
    }
}
