/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }
        PriorityQueue<Interval> roomQueue = new PriorityQueue<>((a, b) -> a.end - b.end);
        intervals.sort((a, b) -> a.start - b.start);
        roomQueue.offer(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            //queue 1-3
            //interval 2 - 4
            if (roomQueue.peek().end > intervals.get(i).start) {
                roomQueue.offer(intervals.get(i));
            } else {
                roomQueue.poll();
                roomQueue.offer(intervals.get(i));
            }
        }

        return roomQueue.size();
    }
}
