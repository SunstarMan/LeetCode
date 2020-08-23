package dfs;

import java.util.ArrayList;
import java.util.List;

/*513. 找树左下角的值
给定一个二叉树，在树的最后一行找到最左边的值。
注意: 您可以假设树（即给定的根节点）不为 NULL。
输入:
    2
   / \
  1   3
输出:1
 */
public class Solution513 {
    public static class TreeNode {
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

    public int findBottomLeftValue(TreeNode root) {
        int depth = getTreeDepth(root);
        List<List<TreeNode>> lists = new ArrayList<>(depth);
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
        return lists.get(lists.size()-1).get(0).val;
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(6);
        TreeNode treeNode1 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(1);
        TreeNode treeNode9 = new TreeNode(4);
        TreeNode treeNode10 = new TreeNode(5);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        treeNode3.left = treeNode7;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode6.right = treeNode10;
        int depth = new Solution513().findBottomLeftValue(treeNode0);
        System.out.println(depth);
    }
}
