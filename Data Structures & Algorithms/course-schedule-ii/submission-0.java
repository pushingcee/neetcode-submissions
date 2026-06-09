class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();   // current DFS path → cycle detection
    Set<Integer> visited  = new HashSet<>();   // fully resolved, don't re-explore
    List<Integer> order   = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build adjList: course -> list of its prerequisites
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());   // seed every course, incl. ones with no prereqs
        }
        for (int[] prereq : prerequisites) {
            adjList.get(prereq[0]).add(prereq[1]);
        }

        // run DFS from every course
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return new int[]{};   // cycle → impossible
            }
        }

        // convert List<Integer> -> int[]
        int[] res = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            res[i] = order.get(i);
        }
        return res;
    }

    private boolean dfs(int course) {
        if (visiting.contains(course)) return false; 
        if (visited.contains(course))  return true;   // already done

        visiting.add(course);

        for (int prereq : adjList.get(course)) {
            if (!dfs(prereq)) return false;            // propagate cycle up
        }

        visiting.remove(course);
        visited.add(course);
        order.add(course);   // <-- post-order add: all prereqs are already in `order`

        return true;
    }
}