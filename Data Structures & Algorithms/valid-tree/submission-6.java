class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < edges.length; i++) {
           addToAdjList(adj, edges[i]);
        }

        if(edges.length != n - 1) {
            return false;
        }

        return isValid(adj, 0, -1, visited) && visited.size() == n;

    }

    private void addToAdjList(Map<Integer, List<Integer>> adj, int[] edge) {
        adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
    }

    boolean isValid(Map<Integer, List<Integer>> adj, int curr, int parent, Set<Integer> visited) {
        if(visited.contains(curr)) {
            return false;
        }

        List<Integer> neibhors = adj.get(curr);
        visited.add(curr);

        if(neibhors != null) {
            for(var element : neibhors) {
                if(element != parent && !isValid(adj, element, curr, visited)) {
                    return false;
                }
            }
        }

        return true;
    }
}
