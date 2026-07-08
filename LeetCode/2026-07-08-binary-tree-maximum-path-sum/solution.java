class Solution {
    private int maxSum = Integer.MIN_VALUE;

    // Time complexity: O(N), where N is the number of nodes in the tree
    // Space complexity: O(H), where H is the height of the tree
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewpath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewpath);

        return node.val + Math.max(leftGain, rightGain);
    }
}