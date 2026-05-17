class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int[][] dp = new int[nums.length][2];
        // 2 , 5 ,3 ,4 
        // 2, 10, 30, 120
        // -3, 10
        // -3

        // [n][0] - alwaysPositive
        // [n][1] - negatives
        dp[0][0] = nums[0]; 
        dp[0][1] = nums[0];

        dp[1][0] = Math.max(dp[0][0] * nums[1], nums[1]); //previous * nums -30
        dp[1][1] = Math.min(dp[0][1] * nums[1], nums[1]);
        int resultR = Math.max(dp[0][0], dp[1][0]);

        for (int i = 2; i < nums.length; i++) {
            int result = dp[i - 1][0] * nums[i];
            int result2 = dp[i - 1][1] * nums[i]; 
            int maxResult = Math.max(result, result2);
            int minResult = Math.min(result, result2);
            dp[i][0] = Math.max(nums[i], Math.max(result, result2));
            dp[i][1] = Math.min(nums[i], Math.min(result, result2));
            resultR = Math.max(resultR, dp[i][0]);
        }

        return resultR;
    }
}
