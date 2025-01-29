class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
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

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, TrieNode node, int i, int j, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || node.children[board[i][j] - 'a'] == null) {
            return;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        TrieNode nextNode = node.children[temp - 'a'];
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null;
        }
        dfs(board, nextNode, i + 1, j, result);
        dfs(board, nextNode, i - 1, j, result);
        dfs(board, nextNode, i, j + 1, result);
        dfs(board, nextNode, i, j - 1, result);
        board[i][j] = temp;
    }
}

