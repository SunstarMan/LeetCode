package dfs;

/*1448. 统计二叉树中好节点的数目
给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
示例 3：
输入：root = [1]
输出：1
解释：根节点是好节点。
提示：
二叉树中节点数目范围是 [1, 10^5] 。
每个节点权值的范围是 [-10^4, 10^4] 。
 */
public class Solution1448 {
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

    private int nodeNum = 0; // 统计好节点的个数
    public int goodNodes(TreeNode root) {
        recursion(root, Integer.MIN_VALUE);
        return nodeNum;
    }

    // max用于记录从顶层递归到本层的最大节点值，
    // 若节点大于max说明该结点不小于该结点到根节点路径上所有节点
    public void recursion(TreeNode node, int max) {
        if (node == null) return;
        if (node.val >= max) {
            nodeNum++;
            max = node.val;
        }
        recursion(node.left, max);
        recursion(node.right, max);
    }

    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(1);
//        TreeNode treeNode3 = new TreeNode(4);
//        TreeNode treeNode4 = new TreeNode(3);
//        TreeNode treeNode5 = new TreeNode(1);
//        TreeNode treeNode6 = new TreeNode(5);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode3.left = treeNode5;
//        treeNode3.right = treeNode6;


//        TreeNode treeNode1 = new TreeNode(9);
//        TreeNode treeNode2 = new TreeNode(3);
//        TreeNode treeNode3 = new TreeNode(6);
//        treeNode1.right = treeNode2;
//        treeNode2.left = treeNode3;

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(8);
        TreeNode treeNode5 = new TreeNode(4);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode4.left = treeNode5;
        int ans = new Solution1448().goodNodes(treeNode1);
        System.out.println(ans);
    }
}
