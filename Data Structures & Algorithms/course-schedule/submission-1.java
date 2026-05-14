class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visiting = new HashSet();
        Set<Integer> visited  = new HashSet<>(); // fully resolved, cycle-free
       
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(preMap, c, visiting, visited)) {
                return false;
            }
        }
        return true;
        
    }

    boolean dfs(Map<Integer, List<Integer>> courseMap, Integer targetCourse, Set<Integer> visiting, Set<Integer> visited) {
    if (visiting.contains(targetCourse)) return false;
    if (visited.contains(targetCourse)) return true;
    visiting.add(targetCourse);
    
    if (courseMap.containsKey(targetCourse)) {
        List<Integer> prerequisites = courseMap.get(targetCourse);
        for (int prereq : prerequisites) {
            if (!dfs(courseMap, prereq, visiting, visited)) return false;
        }
    }
    
    visiting.remove(targetCourse);
    visited.add(targetCourse);

    return true;
}
}