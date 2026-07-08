class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int preIndex = 0, postIndex = 0;
        return construct(preorder, postorder, preIndex, postIndex);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int preIndex, int postIndex) {
        if (preIndex >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (preIndex >= preorder.length) return root;
        if (preorder[preIndex] != postorder[postIndex]) {
            root.left = construct(preorder, postorder, preIndex, postIndex);
            root.right = construct(preorder, postorder, preIndex, postIndex + 1);
        } else {
            postIndex++;
            root.left = construct(preorder, postorder, preIndex, postIndex);
            root.right = construct(preorder, postorder, preIndex, postIndex);
        }
        return root;
    }
}