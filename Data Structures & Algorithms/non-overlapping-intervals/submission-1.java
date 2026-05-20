class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); //sort ascending
        
        int overlaps = 0;
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i - 1][1] > intervals[i][0]) {
                overlaps++;
                if(intervals[i][1] < intervals[i - 1][1]) {
                    continue;
                } else {
                    intervals[i] = intervals[i - 1];
                }
            }
        }   

        return overlaps;
    }
}
