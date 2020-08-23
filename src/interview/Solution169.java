package interview;

/*169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
输入: [3,2,3]
输出: 3
输入: [2,2,1,1,1,2,2]
输出: 2
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int result=nums[0];
        int count =1;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=result){
                count--;
                if(count==0){
                    count=1;
                    result=nums[i];
                }
            }
            else{
                count++;
            }
        }
        return result;
    }
}
