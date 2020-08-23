package recursion;

/*687. 最长同值路径
给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
注意：两个节点之间的路径长度由它们之间的边数表示。
 */
public class Solution687 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int ans = 0;

    private int uniValue(TreeNode root) {
        if (root == null) return 0;

        int left = uniValue(root.left);
        int right = uniValue(root.right);

        left = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        right = (root.right != null && root.right.val == root.val) ? right + 1 : 0;

        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }

    public int longestUnivaluePath(TreeNode root) {
        uniValue(root);
        return ans;
    }


}
