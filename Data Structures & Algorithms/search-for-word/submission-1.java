class Solution {
    public boolean exist(char[][] board, String word) {
        Set<List<Integer>> visited = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(dfs(board, 0, word, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int wordIndex, String word, int row, int col, Set<List<Integer>> visited) {
        if (wordIndex == word.length()) return true;
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return false;
        }

        if(visited.contains(List.of(row, col))) {
            return false;
        }

        List<Integer> current = List.of(row, col);
        visited.add(current);

        if(board[row][col] == word.charAt(wordIndex)) {
            if( dfs(board, wordIndex + 1, word, row + 1, col, visited) ||
            dfs(board, wordIndex + 1, word, row, col + 1, visited) ||
            dfs(board, wordIndex + 1, word, row - 1, col, visited) ||
            dfs(board, wordIndex + 1, word, row, col - 1, visited)) {
                return true;
            }
        } 
        visited.remove(current);
        return false;
    }
}
