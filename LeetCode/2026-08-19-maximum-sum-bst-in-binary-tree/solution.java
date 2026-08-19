class Solution {
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        // Time complexity: O(n), where n is the number of nodes in the tree
        // Space complexity: O(h), where h is the height of the tree
        dfs(root);
        return maxSum;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {0, 1, Integer.MIN_VALUE, Integer.MAX_VALUE};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        if (left[1] == 1 && right[1] == 1 && node.val > left[2] && node.val < right[3]) {
            int sum = node.val + left[0] + right[0];
            maxSum = Math.max(maxSum, sum);
            return new int[] {sum, 1, Math.max(node.val, right[2]), Math.min(node.val, left[3])};
        }

        return new int[] {0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE};
    }
}