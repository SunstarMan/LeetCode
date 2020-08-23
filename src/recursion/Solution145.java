package recursion;

import java.util.ArrayList;
import java.util.List;

/*145. 二叉树的后序遍历
给定一个二叉树，返回它的后序遍历:先左后右再根，即首先遍历左子树，然后遍历右子树，最后访问根结点
 */
public class Solution145 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void postorder(Solution145.TreeNode root, List<Integer> ans) {
        if (root == null) return;
        else {
            postorder(root.left,ans);
            postorder(root.right,ans);
            ans.add(root.val);
        }
    }

    public List<Integer> postorderTraversal(Solution145.TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }
}
