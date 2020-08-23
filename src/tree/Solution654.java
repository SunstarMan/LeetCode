package tree;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/*654. 最大二叉树
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。
输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：
      6
    /   \
   3     5
    \    /
     2  0
       \
        1
提示：给定的数组的大小在 [1, 1000] 之间。
 */
public class Solution654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //计算最大值的下标
    public int maxIndex(int[] a, int l, int r) {
        int max = a[l];
        int index = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] > max) {
                max = a[i];
                index = i;
            }
        }
        return index;
    }

    public TreeNode recursionTree(int[] nums, int l, int r) {
        if (l > r) return null;

        int index = maxIndex(nums, l, r);
        TreeNode treeNode = new TreeNode(nums[index]);//最大值
        if (index > l) {
            treeNode.left = recursionTree(nums, l, index - 1);
        }
        if (index < r) {
            treeNode.right = recursionTree(nums, index + 1, r);
        }
        return treeNode;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int r = nums.length - 1;
        TreeNode treeNode = recursionTree(nums, 0, r);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 6, 0, 5};
        System.out.println(new Solution654().constructMaximumBinaryTree(a));
    }
}
