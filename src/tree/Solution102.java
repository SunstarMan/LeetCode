package tree;

import java.util.ArrayList;
import java.util.List;

/*102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
二叉树：[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：[[3],[9,20],[15,7]]
 */
public class Solution102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int getTreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        return 1 + Math.max(left, right);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        int depth = getTreeDepth(root);
        List<List<TreeNode>> lists = new ArrayList<>(depth);
        List<List<Integer>> ans=new ArrayList<>();
        if (depth == 0) return ans;
        for (int i = 0; i < depth; i++) {
            lists.add(new ArrayList<>());
        }
        lists.get(0).add(root);

        int index = 1;
        while (index < depth) {
            for (int i = 0; i < lists.get(index - 1).size(); i++) {
                if (lists.get(index - 1).get(i).left != null) {
                    lists.get(index).add(lists.get(index - 1).get(i).left);
                }
                if (lists.get(index - 1).get(i).right != null) {
                    lists.get(index).add(lists.get(index - 1).get(i).right);
                }
            }
            index++;
        }
        for (int i = 0; i < lists.size(); i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < lists.get(i).size(); j++) {
                ans.get(i).add(lists.get(i).get(j).val);
            }
        }
        return ans;
    }
}
