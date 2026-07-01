/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root, result);
        return result;
    }

    private void inorderTraversalHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderTraversalHelper(node.left, result);
        result.add(node.val);
        inorderTraversalHelper(node.right, result);
    }
}