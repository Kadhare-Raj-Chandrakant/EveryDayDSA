class Solution {
    // Time complexity: O(m * n * 4^L + N), where m is the number of rows, n is the number of columns, L is the maximum length of a word, and N is the total number of words.
    // Space complexity: O(N), where N is the total number of words.
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }
        char c = board[i][j];
        if (node.children[c - 'a'] == null) {
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, node.children[c - 'a'], result);
        dfs(board, i + 1, j, node.children[c - 'a'], result);
        dfs(board, i, j - 1, node.children[c - 'a'], result);
        dfs(board, i, j + 1, node.children[c - 'a'], result);
        board[i][j] = c;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}