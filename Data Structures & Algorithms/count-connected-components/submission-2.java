class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet();
        int graphCounter = 0;
        int graphIndex = 0;

        for(int i = 0; i < edges.length; i++) {
            addToAdjList(adj, edges[i]);
        }

        while(visited.size() != n) {
            if(!visited.contains(graphIndex)) {
                dfs(adj, graphIndex, visited);
                graphCounter++;
            }
            graphIndex++;
        }

        return graphCounter;

    }

    private void addToAdjList(Map<Integer, List<Integer>> adj, int[] edge){
        adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
    }

    private void dfs(Map<Integer, List<Integer>> adj, int current, Set<Integer> visited){
        if(visited.contains(current)){
            return;
        }

        List<Integer> neibors = adj.get(current);
        visited.add(current);

        if(neibors != null) {
            for (var neibor : neibors) {
                dfs(adj, neibor, visited);
            }
        }
    }
}
