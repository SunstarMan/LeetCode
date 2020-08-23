package dfs;

import java.util.ArrayList;
import java.util.List;

/*39. 组合总和
给定一个无重复元素的数组candidates和一个目标数target,找出candidates中所有可以使数字和为target的组合。
candidates 中的数字可以无限制重复被选取。
说明：所有数字（包括 target）都是正整数。解集不能包含重复的组合
输入: candidates = [2,3,6,7], target = 7,
所求解集为:[[7],[2,2,3]]
输入: candidates = [2,3,5], target = 8,
所求解集为:[[2,2,2,2],[2,3,3],[3,5]]
 */
public class Solution39 {
    private List<List<Integer>> ans;
    public void dfs(int[] candidates, int target, int l, int r, int sum, List<Integer> list) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        int nextNum;
        for (int i = l; i < r; i++) {
            nextNum = candidates[i];
            if (sum + nextNum <= target) {
                list.add(nextNum);
                sum += nextNum;
                dfs(candidates, target, i, r, sum, list);
                sum -= nextNum;
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        int len = candidates.length;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, len, sum, list);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = new Solution39().combinationSum(a, target);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
