package array;

import java.util.ArrayList;
import java.util.List;

/*78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        /*List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++){
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            }
            res.add(sub);
        }
        return res;
        */


        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> plusNumbers = new ArrayList<>();
            for(List<Integer> result : results) {
                List<Integer> newNumber = new ArrayList<>(result);
                newNumber.add(nums[i]);
                plusNumbers.add(newNumber);
            }
            results.addAll(plusNumbers);
        }
        return results;
    }
}
