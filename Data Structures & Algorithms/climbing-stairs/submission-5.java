class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int[] results = new int[]{1, 2};

        for(int i = 2; i < n; i++) {
            int temp = results[1];
            results[1] = results[0] + results [1];
            results[0] = temp;
        }

        return results[1];

    }
}
