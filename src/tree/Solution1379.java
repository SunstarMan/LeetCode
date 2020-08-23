package tree;

/*1379. 找出克隆二叉树中的相同节点
给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
其中，克隆树 cloned 是原始树 original 的一个 副本 。
请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回节点指针，其他语言返回节点本身）。
注意：你 不能 对两棵二叉树，以及 target 节点进行更改。
只能 返回对克隆树 cloned 中已有的节点的引用。
进阶：如果树中允许出现值相同的节点，你将如何解答？
输入: tree = [7,4,3,null,null,6,19], target = 3
输出: 3
解释: 上图画出了树 original 和 cloned。target 节点在树 original 中，用绿色标记。答案是树 cloned 中的黄颜色的节点（其他示例类似）。
提示：树中节点的数量范围为 [1, 10^4] 。
同一棵树中，没有值相同的节点。
target 节点是树 original 中的一个节点，并且不会是 null 。
 */
public class Solution1379 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) {
            return cloned;
        }
        TreeNode ans = getTargetCopy(original.left, cloned.left, target);
        return ans == null ? getTargetCopy(original.right, cloned.right, target) : ans;
    }

    public static void main(String[] args) {
        TreeNode treeNode0=new TreeNode(7);
        TreeNode treeNode1=new TreeNode(4);
        TreeNode treeNode2=new TreeNode(3);
        TreeNode treeNode3=new TreeNode(6);
        TreeNode treeNode4=new TreeNode(19);
        treeNode0.left=treeNode1;
        treeNode0.right=treeNode2;
        treeNode2.left=treeNode3;
        treeNode2.right=treeNode4;
        TreeNode treeNode=new TreeNode(3);
        System.out.println((new Solution1379().getTargetCopy(treeNode0,treeNode0,treeNode)).val);
    }
}
