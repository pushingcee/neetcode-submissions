class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        // Set<Integer> visited = new HashSet(); add later for optimization
        Set<Integer> visiting = new HashSet();
        Set<Integer> visited = new HashSet();

        for(int i = 0; i < prerequisites.length; i++) {
            adjList.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>()).add(prerequisites[i][1]);
        }

        // because adjList.length is only the prereq pairs, i want to check all of the courses;
        for(int i = 0; i < numCourses; i++){
            if(hasCycleDfs(adjList, i, visiting, visited)) {
                return false;
            }
        }

        return true;
    }

    public boolean hasCycleDfs(Map<Integer, List<Integer>> adjList, int current, Set<Integer> visiting, Set<Integer> visited) {
        if(visiting.contains(current)) {
            return true;
        } 
        if(visited.contains(current)){
            return false;
        }

        visiting.add(current);

        List<Integer> prereqsForCurrent = adjList.get(current);

        if(prereqsForCurrent != null) {
            for(var prereq: prereqsForCurrent) {
                //will hit one that's already visited or will go down;
                if(hasCycleDfs(adjList, prereq, visiting, visited)) {
                    return true;
                }
            }
        }

        visiting.remove(current);
        visited.add(current);

        return false;
    }





    

}


