// Time complexity: O(n), where n is the number of nodes in the tree
// Space complexity: O(h), where h is the height of the tree
class Solution {
    int maxDepth = 0;
    TreeNode result = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) return depth;
        maxDepth = Math.max(maxDepth, depth);
        int leftDepth = dfs(node.left, depth + 1);
        int rightDepth = dfs(node.right, depth + 1);
        if (leftDepth == maxDepth && rightDepth == maxDepth) {
            result = node;
        }
        return Math.max(leftDepth, rightDepth);
    }
}