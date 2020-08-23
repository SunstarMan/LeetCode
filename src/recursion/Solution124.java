package recursion;

/*124. 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。
本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
该路径至少包含一个节点，且不一定经过根节点。
 */
public class Solution124 {
    int max_sum=Integer.MIN_VALUE;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int maxGain(TreeNode root){
        if (root==null) return 0;

        int left_gain=Math.max(maxGain(root.left),0);
        int right_gain=Math.max(maxGain(root.right),0);

        int newPath=root.val+left_gain+right_gain;
        max_sum = Math.max(max_sum, newPath);

        // return the max gain if continue the same path
        return root.val+Math.max(left_gain,right_gain);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max_sum;
    }
}
