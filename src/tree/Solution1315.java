package tree;

import java.util.ArrayList;
import java.util.List;

/*1315. 祖父节点值为偶数的节点和
给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。
输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：18
解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
提示：树中节点的数目在 1 到 10^4 之间。
每个节点的值在 1 到 100 之间。
 */
public class Solution1315 {
    public static class TreeNode {
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
        System.out.println(new Solution1315().sumEvenGrandparent(treeNode0));
    }
}
