package dfs;

import java.util.ArrayList;
import java.util.List;

/*1315. 祖父节点值为偶数的节点和(done)
给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。
 */
public class Solution1315 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int getTreeDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int left = getTreeDepth(treeNode.left);
        int right = getTreeDepth(treeNode.right);
        return 1 + Math.max(left, right);
    }

    public List<Integer> recursion(TreeNode root, List<Integer> list) {
        if (root == null) return null;
        if (root.val % 2 == 0 && getTreeDepth(root) >= 3) {
            if (root.left != null) {
                TreeNode left = root.left;
                if (left.left != null) list.add(left.left.val);
                if (left.right != null) list.add(left.right.val);
                recursion(left, list);
            }
            if (root.right != null) {
                TreeNode right = root.right;
                if (right.left != null) list.add(right.left.val);
                if (right.right != null) list.add(right.right.val);
                recursion(right, list);
            }
        }
        if (root.val % 2 != 0 && getTreeDepth(root) >= 3) {
            recursion(root.left, list);
            recursion(root.right, list);
        }
        return list;
    }

    public int sumEvenGrandparent(TreeNode root) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        list = recursion(root, list);
        for (int i = 0; i < list.size(); i++) {
            ans += list.get(i);
        }
        return ans;
    }
}
