package backtracking;

import java.util.ArrayList;
import java.util.List;

/*46. 全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Solution46 {

//    public List<List<Integer>> rank(int[] nums, boolean[] used, int t, List<Integer> ans) {
//        List<List<Integer>> lists = new ArrayList<>();
//        t = ans.size();
//        while (t == nums.length) {
//            lists.add(ans);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!used[i]) {
//                used[i] = true;
//
//                ans.set(t, nums[i]);
//                rank(nums, used, t + 1, ans);
//                lists.add(ans);
//                ans.set(t, 0);
//
//                used[i] = false;
//            }
//        }
//        return null;
//    }

    public void rank(int[] nums, boolean[] used, ArrayList<Integer> t, List<List<Integer>> ans) {
        if (t.size() == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;

                t.add(nums[i]);
                rank(nums, used, t, ans);

                used[i] = false;
                t.remove(t.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        rank(nums, used, new ArrayList<Integer>(), ans);
        return ans;
    }
}
