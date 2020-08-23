package dfs;

/*104. 二叉树的最大深度(done)
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
 */
public class Solution104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int depthL = maxDepth(root.left);
        int depthR = maxDepth(root.right);

        return depthL > depthR ? depthL + 1 : depthR + 1;
    }
}
