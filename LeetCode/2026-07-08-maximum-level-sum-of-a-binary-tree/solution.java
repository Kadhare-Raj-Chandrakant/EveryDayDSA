class Solution {
    // Time complexity: O(n), where n is the number of nodes in the tree
    // Space complexity: O(n), where n is the number of nodes in the tree
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            level++;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
        }
        
        return maxLevel;
    }
}