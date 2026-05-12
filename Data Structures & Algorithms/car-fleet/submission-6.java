public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        // one place position one place car

        for(int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> b[0] - a[0]);

        int fleets = 0;
        double maxTime = 0;

        for (int i = 0; i < n; i++) {
            double t = (double)(target - pair[i][0]) / pair[i][1];
            if (t > maxTime) {
                maxTime = t;
                fleets++;
            }
        }
        return fleets;
    }
}