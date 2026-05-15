class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        // Set<Integer> visited = new HashSet(); add later for optimization
        Set<Integer> visiting = new HashSet();

        for(int i = 0; i < prerequisites.length; i++) {
            adjList.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>()).add(prerequisites[i][1]);
        }

        // because adjList.length is only the prereq pairs, i want to check all of the courses;
        for(int i = 0; i < numCourses; i++){
            if(hasCycleDfs(adjList, i, visiting)) {
                return false;
            }
        }

        return true;
    }

    public boolean hasCycleDfs(Map<Integer, List<Integer>> adjList, int current, Set<Integer> visiting) {
        if(visiting.contains(current)) {
            return true;
        } 

        visiting.add(current);

        List<Integer> prereqsForCurrent = adjList.get(current);

        if(prereqsForCurrent != null) {
            for(var prereq: prereqsForCurrent) {
                //will hit one that's already visited or will go down;
                if(hasCycleDfs(adjList, prereq, visiting)) {
                    return true;
                }
            }
        }

        visiting.remove(current);

        return false;
    }





    

}


