package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。
注意:你可以假设树中没有重复的元素。
给出:中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
 */
public class Solution106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int postIndex;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> mapInorder = new HashMap<>();

    public TreeNode recursion(int l, int r) {
        if (l > r) return null;
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = mapInorder.get(rootVal);
        postIndex--;
        root.right = recursion(index + 1, r);
        root.left = recursion(l, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        postIndex = postorder.length - 1;
        for (int i = 0; i <= postIndex; i++) {
            mapInorder.put(inorder[i], i);
        }
        return recursion(0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] in = {9, 3, 15, 20, 7};
        int[] post = {9, 15, 7, 20, 3};
        TreeNode root=new Solution106().buildTree(in,post);
        System.out.println(root);
    }
}
