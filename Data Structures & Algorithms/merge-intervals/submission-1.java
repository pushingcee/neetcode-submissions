class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            if(isIntervalOverlapping(output.getLast(), intervals[i])) {
                int[] last = output.getLast();
                merge(last, intervals[i]);
            } else {
                output.add(intervals[i]);
            }
        }

        return output.toArray(new int[output.size()][]);
    }

    private boolean isIntervalOverlapping(int[] a, int[] b) {
        boolean standardOverlap = a[1] >= b[0];
        boolean completeSubset = a[0] <= b[0] && a[1] >= b[1] || b[0] <= a[0] && b[1] >= a[1];
        return standardOverlap || completeSubset;
    }

    private void merge(int[] a, int[] b) {
        a[0] = Math.min(a[0], b[0]);
        a[1] = Math.max(a[1], b[1]);
    }
}
