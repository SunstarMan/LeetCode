package dfs;

/*面试题 04.02. 最小高度树
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
给定有序数组: [-10,-3,0,5,9],
一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
          0
         / \
       -3   9
       /   /
     -10  5
 */
public class Solution04_02 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode recursion(int[] a, int l, int r) {
        if (l > r) return null;
        int mid;
        mid = (l + r) / 2;//选取的中点的下标（数组长度为偶数时选中心较大的一个数）

        TreeNode treeNode = new TreeNode(a[mid]);
        if (mid > l) {
            treeNode.left = recursion(a, l, mid - 1);
        }
        if (mid < r) {
            treeNode.right = recursion(a, mid + 1, r);
        }
        return treeNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {-10, -3, 0, 5, 9};
        TreeNode treeNode = new Solution04_02().sortedArrayToBST(a);
    }
}
