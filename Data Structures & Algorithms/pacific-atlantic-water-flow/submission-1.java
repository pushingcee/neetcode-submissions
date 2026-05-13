class Solution {

    public record Pair(int row, int col) {}

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> results = new ArrayList();
        Set<Pair> atlantic = new HashSet();
        Set<Pair> pacific = new HashSet();
    
        for(int i = 0; i < heights[0].length; i++) {
            dfs(heights, 0, i, heights[0][i], pacific);
            dfs(heights, heights.length - 1, i, heights[heights.length - 1][i], atlantic);
        }

        for(int i = 0; i < heights.length; i++) {
            dfs(heights, i, 0, heights[i][0], pacific);
            dfs(heights, i, heights[i].length - 1, heights[i].length-1, atlantic);
        }

        for(Pair coords : atlantic) {
            if(pacific.contains(coords)) {
                results.add(List.of(coords.row, coords.col));
            }
        }

        return results;
    }

    private void dfs(int[][] heights, int row, int col, int prevCell, Set<Pair> tracker) {
        if(row < 0 || col < 0 || row >= heights.length || col >= heights[row].length || prevCell > heights[row][col] || tracker.contains(new Pair(row, col))){
            return;
        }

        tracker.add(new Pair(row, col));

        dfs(heights, row + 1, col, heights[row][col], tracker);
        dfs(heights, row, col + 1, heights[row][col], tracker);
        dfs(heights, row - 1, col, heights[row][col], tracker);
        dfs(heights, row, col - 1, heights[row][col], tracker);
    }
}
