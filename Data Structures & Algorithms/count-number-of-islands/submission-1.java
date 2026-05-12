class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0; 

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int row, int column) {
        if(row > grid.length - 1 || row < 0 || column > grid[row].length -1 || column < 0 || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';

        dfs(grid, row + 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row - 1, column);
        dfs(grid, row, column - 1);
        // dfs -> dfs -> dfs -> dfs -> 
    }
}
