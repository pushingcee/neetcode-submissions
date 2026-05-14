class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet();
        Set<Integer> visiting = new HashSet();

        for(int i = 0; i < prerequisites.length; i++) {
            adjList.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>()).add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(adjList, i,visiting, visited)){
                return false;
            }
        }

        return true;
        
    }

    // boolean dfs(Map<Integer, List<Integer>> courseMap, Integer targetCourse, Set<Integer> visiting, Set<Integer> visited) {

    boolean dfs(Map<Integer, List<Integer>> courseMap, Integer targetCourse, Set<Integer> visiting, Set<Integer> visited) {
        if(visited.contains(targetCourse)){
            return true;
        }
        if(visiting.contains(targetCourse)){
            return false;
        }
        
        visiting.add(targetCourse);

        if(courseMap.containsKey(targetCourse)) {
            List<Integer> prerequisites = courseMap.get(targetCourse);
            for(int prereq: prerequisites) {
                if (!dfs(courseMap, prereq, visiting, visited)) return false;
            }
        }

        visiting.remove(targetCourse);

        return true;
    }
}