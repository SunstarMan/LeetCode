package dfs;

import java.util.HashMap;
import java.util.Map;

/*105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
 */
public class Solution105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;

        if (preLength != inLength) {
            throw new RuntimeException("incorrect input");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preLength - 1, map, 0, inLength - 1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode treeNode = new TreeNode(rootVal);
        int preIndex = map.get(rootVal);
        treeNode.left = build(preorder, preLeft + 1, preIndex - inLeft + preLeft, map, inLeft, preIndex - 1);
        treeNode.right = build(preorder, preIndex - inLeft + preLeft + 1, preRight, map, preIndex + 1, inRight);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = new Solution105().buildTree(preorder, inorder);
        System.out.println(treeNode.val);
    }
}
