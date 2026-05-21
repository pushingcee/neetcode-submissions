class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, 0, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int wordIndex, String word, int row, int col) {
        if (wordIndex == word.length()) return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return false;
        }

        if (board[row][col] != word.charAt(wordIndex)) return false;

        char temp = board[row][col];
        board[row][col] = '#';

        if (dfs(board, wordIndex + 1, word, row + 1, col) ||
            dfs(board, wordIndex + 1, word, row, col + 1) ||
            dfs(board, wordIndex + 1, word, row - 1, col) ||
            dfs(board, wordIndex + 1, word, row, col - 1)) {
            board[row][col] = temp;
            return true;
        }

        board[row][col] = temp;
        return false;
    }
}