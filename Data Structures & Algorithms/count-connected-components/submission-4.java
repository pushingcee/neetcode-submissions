class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int connections = 0;

        for (int i = 0; i < edges.length; i++) {
            addToAdjList(adj, edges[i]);
        }



        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                dfs(adj, i, visited);
                connections++;
            }
        }

        return connections;
    }

    private void addToAdjList(Map<Integer, List<Integer>> adj, int[] edge){
        adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
    }

    private void dfs(Map<Integer, List<Integer>> adj, int current, Set<Integer> visited){
        if(visited.contains(current)){
            return;
        }

        visited.add(current);
        List<Integer> neighbours = adj.get(current);
        
        if(neighbours != null) {
            for(Integer neighbour : neighbours) {
                dfs(adj, neighbour, visited);
            }
        }
    }
}
