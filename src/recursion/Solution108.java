package recursion;

import java.util.Arrays;

/*108. 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Solution108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums);
    }

    private TreeNode recursion(int[] nums){
        int len=nums.length;
        if(len == 0) return null;

        TreeNode root = new TreeNode(nums[len/2]);
        // Arrays.copyOfRange:将一个原始的数组nums，从下标from开始复制，复制到上标to，生成一个新的数组。
        //注意这里包括下标from，不包括上标to。
        root.left = recursion(Arrays.copyOfRange(nums,0,len/2));
        root.right = recursion(Arrays.copyOfRange(nums,len/2+1,len));
        return root;
    }

    public static void main(String[] args) {
        int[] nums={-10,-3,0-5-9};
        System.out.println(new Solution108().sortedArrayToBST(nums));
    }
}

