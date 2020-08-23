package recursion;

import java.util.ArrayList;
import java.util.List;

/*94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历:中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。
 */
public class Solution94 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        else {
            inorder(root.left, ans);
            ans.add(root.val);
            inorder(root.right, ans);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
