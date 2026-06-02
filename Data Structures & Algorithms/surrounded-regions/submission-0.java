class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {

    // top + bottom — iterate columns
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') mark(board, 0, i, '#', 'O');
            if (board[board.length - 1][i] == 'O') mark(board, board.length - 1, i, '#', 'O');
        }

        // left + right — iterate rows
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') mark(board, i, 0, '#', 'O');
            if (board[i][board[i].length - 1] == 'O') mark(board, i, board[i].length - 1, '#', 'O');
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void mark(char[][] board, int row, int col, char marker, char target) {
        if(row == board.length || row < 0 || col == board[row].length  || col < 0 || board[row][col] != target) {
            return;
        }

        board[row][col] = marker;

        for(var dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            mark(board, nr, nc, marker, target);
        }
    }
}