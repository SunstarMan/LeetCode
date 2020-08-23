package dfs;

/*129. 求根到叶子节点数字之和
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
例如，从根到叶子节点路径 1->2->3 代表数字 123。
计算从根到叶子节点生成的所有数字之和。
说明: 叶子节点是指没有子节点的节点。
示例 1:
输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
 */
public class Solution129 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void dfs(TreeNode root, int tempSum, int[] ans) {
        // 截止条件
        if (root.left == null && root.right == null) {
            ans[0] += tempSum;
            return;
        }

        // 候选节点
        if (root.left != null) {
            dfs(root.left, tempSum * 10 + root.left.val, ans);
        }
        if (root.right != null) {
            dfs(root.right, tempSum * 10 + root.right.val, ans);
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ans = new int[1];
        dfs(root, root.val, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        int ans=new Solution129().sumNumbers(treeNode1);
        System.out.println(ans);
    }
}
