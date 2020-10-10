class Solution {
    // 本题思路：
    // 遇到目标单词的首字母就开始dfs
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        // 终止条件
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]) return false;
        // 标记访问过了
        visited[i][j] = true;
        boolean res = dfs(board, word, visited, i + 1, j, index + 1) || dfs(board, word, visited, i - 1, j, index + 1) || dfs(board, word, visited, i, j + 1, index + 1) || dfs(board, word, visited, i, j - 1, index + 1);
        visited[i][j] = false;
        return res;
    }
}