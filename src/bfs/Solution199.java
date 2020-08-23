package bfs;

import java.util.ArrayList;
import java.util.List;

/*199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
示例:
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
public class Solution199 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isStop(List<TreeNode> temp) {
        boolean flag = true;
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).left != null || temp.get(i).right != null) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        ans.add(root.val);
        if (root.left == null && root.right == null) {
            return ans;
        } else {
            List<TreeNode> temp = new ArrayList<TreeNode>();
            temp.add(root);

            while (!isStop(temp)) {
                int size = temp.size();
                for (int i = 0; i < size; i++) {
                    if (temp.get(i).left != null) {
                        temp.add(temp.get(i).left);
                    }
                    if (temp.get(i).right != null) {
                        temp.add(temp.get(i).right);
                    }
                }
                ans.add(temp.get(temp.size() - 1).val);
                for (int i = 0; i < size; i++) {
                    temp.remove(0);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode3;
        List<Integer> ans = new Solution199().rightSideView(treeNode0);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
