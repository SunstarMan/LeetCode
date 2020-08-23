package dfs;

/*559. N叉树的最大深度(done)
给定一个 N 叉树，找到其最大深度。
最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

//使用递归，找到当前节点所有孩子节点中最深的一支，+1即为当前节点深度
public class Solution559 {
    private int max(int a, int b) {
        if (a >= b) return a;
        else return b;
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;

        for (int i = 0; i < root.children.size(); i++) { // 遍历每个子节点
            depth = max(depth, maxDepth(root.children.get(i))); // 选择最大子树深度
        }
        return 1 + depth;
    }
}
