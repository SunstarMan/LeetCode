package dfs;

import java.util.ArrayList;
import java.util.List;

/*114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。
输入：
    1
   / \
  2   5
 / \   \
3   4   6
输出：
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class Solution114 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;

        if (left != null) {
            flatten(left);
            root.right = left;
        }
        if (right != null) {
            flatten(right);
            TreeNode temp = root;
            while (temp.right != null) temp = temp.right;
            temp.right = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        new Solution114().flatten(treeNode1);
    }
}
