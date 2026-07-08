// Time complexity: O(n), where n is the number of nodes in the tree
// Space complexity: O(n), for the recursion stack and the result vector
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        inorderTraversalHelper(root, result);
        return result;
    }

private:
    void inorderTraversalHelper(TreeNode* node, vector<int>& result) {
        if (node == nullptr) {
            return;
        }
        inorderTraversalHelper(node->left, result);
        result.push_back(node->val);
        inorderTraversalHelper(node->right, result);
    }
};