package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*面试题 04.03. 特定深度节点链表
给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
返回一个包含所有深度的链表的数组。
输入：[1,2,3,4,5,null,7,8]

        1
       /  \
      2    3
     / \    \
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]
 */
public class Solution04_03 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //获取一棵树的深度：从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
    private int getTreeDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int left = getTreeDepth(treeNode.left);
        int right = getTreeDepth(treeNode.right);
        return 1 + Math.max(left, right);
    }


    //找出一棵树某一深度的所有节点
//    private void getNodesKDepth(TreeNode root, int k, Queue<TreeNode> queue) {
//        if (root == null || k <= 0) return;
//        if (k == 1) {
//            queue.add(root);
//            return;
//        }
//        if (root.left != null)
//            getNodesKDepth(root.left, k - 1, queue);
//        if (root.right != null)
//            getNodesKDepth(root.right, k - 1, queue);
//    }


    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return null;
        int depth = getTreeDepth(tree);
        List<List<TreeNode>> lists = new ArrayList<>(depth);
        for (int i = 0; i < depth; i++) {
            lists.add(new ArrayList<>());
        }
        lists.get(0).add(tree);

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

        ListNode[] listNodes = new ListNode[depth];
        for (int i = 0; i < depth; i++) {
            ListNode listNode = new ListNode(lists.get(i).get(0).val);
            ListNode temp = listNode;
            for (int j = 1; j < lists.get(i).size(); j++) {
                temp.next = new ListNode(lists.get(i).get(j).val);
                temp = temp.next;
            }
            listNodes[i] = listNode;
        }
        return listNodes;
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(8);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode4.left = treeNode6;
        treeNode2.right = treeNode5;
        ListNode[] ans =new Solution04_03().listOfDepth(treeNode0);
        for (int i = 0; i < 4; i++) {
            System.out.println(ans[i].val);
        }
    }
}
