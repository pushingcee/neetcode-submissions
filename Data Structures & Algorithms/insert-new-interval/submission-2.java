class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};

        // Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> output = new ArrayList();

        boolean intervalAdded = false;

        int i = 0;

        for (; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                output.add(newInterval);
                intervalAdded = true;
                break;
            } else if (newInterval[0] <= intervals[i][1]) {
                int[] mergedInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
                output.add(mergedInterval);
                intervalAdded = true;
                break;
            } else {
                output.add(intervals[i]);
            }
        }

        if (!intervalAdded) output.add(newInterval);

        for (; i < intervals.length; i++) {
            if (output.getLast()[1] >= intervals[i][0]) {
                output.getLast()[0] = Math.min(output.getLast()[0], intervals[i][0]);
                output.getLast()[1] = Math.max(output.getLast()[1], intervals[i][1]);
            } else {
                break;
            }
        }

        for (; i < intervals.length; i++) {
            output.add(intervals[i]);
        }

        return output.toArray(new int[output.size()][]);
    }
}
