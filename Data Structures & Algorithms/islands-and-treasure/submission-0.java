class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] treasureCoords = queue.poll();
            for (var dir : directions) {
                int nr = treasureCoords[0] + dir[0];
                int nc = treasureCoords[1] + dir[1];

                if(nr < 0 || nc < 0 || nr == grid.length || nc == grid[0].length || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[nr][nc] = grid[treasureCoords[0]][treasureCoords[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
