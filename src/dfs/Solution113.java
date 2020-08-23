package dfs;

import java.util.ArrayList;
import java.util.List;

/*113. 路径总和 II(done)
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。
 */
public class Solution113 {
    private List<List<Integer>> ans;
    private List<Integer> paths;
    private int targetSum;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans=new ArrayList<>();
        paths=new ArrayList<>();
        targetSum=sum;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if (root.left==null&&root.right==null){
            int sum=0;
            for (Integer path : paths) {
                sum=sum+path;
            }
            sum=sum+root.val;
            if (sum==targetSum){
                ArrayList<Integer> list=new ArrayList<>(paths);
                list.add(root.val);
                ans.add(list);
            }
            return;
        }
        if (root.left!=null){
            paths.add(root.val);
            dfs(root.left);
            paths.remove(paths.size()-1);
        }
        if (root.right!=null){
            paths.add(root.val);
            dfs(root.right);
            paths.remove(paths.size()-1);
        }
    }

    //力扣题解
    /*List<List<Integer>> list = new ArrayList<>();
    ArrayList<Integer> inner = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return list;
        sum =sum- root.val;
        inner.add(root.val);  // 入列表

        if (root.left == null && root.right == null){
            if (sum == 0){
                list.add(new ArrayList<>(inner));  //拷贝
            }
        }

        if (root.left != null)  pathSum(root.left, sum);
        if (root.right != null)  pathSum(root.right, sum);

        inner.remove(inner.size()-1);  //从列表中删除
        return list;
    }*/

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(8);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(11);
        treeNode1.left = treeNode3;
        TreeNode treeNode4 = new TreeNode(13);
        TreeNode treeNode5 = new TreeNode(4);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(2);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        TreeNode treeNode8 = new TreeNode(5);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        System.out.println(new Solution113().pathSum(treeNode0, 22));
    }
}
