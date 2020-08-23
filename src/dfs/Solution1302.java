package dfs;

import java.util.LinkedList;
import java.util.Queue;

/*1302. 层数最深叶子节点的和
给你一棵二叉树，请你返回层数最深的叶子节点的和。
 */
public class Solution1302 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //队列
  public int deepestLeavesSum(TreeNode root) {
      if (root == null) return 0;

      int sum = 0;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
          sum = 0;
          int size = queue.size();
          for (int i = 0; i < size; i++) {
              TreeNode node = queue.poll();
              sum =sum + node.val;
              if (node.left != null) queue.offer(node.left);
              if (node.right != null) queue.offer(node.right);
          }
      }
      return sum;
  }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(8);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(11);
        treeNode1.left = treeNode3;
        TreeNode treeNode4 = new TreeNode(13);
        TreeNode treeNode5 = new TreeNode(4);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(2);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        TreeNode treeNode8 = new TreeNode(5);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        System.out.println(new Solution1302().deepestLeavesSum(treeNode0));
    }
}
