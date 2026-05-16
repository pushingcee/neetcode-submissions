class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] profits = new int[2];
        
        profits[0] = nums[0];
        profits[1] = Math.max(nums[1], nums[0]);

        for(int i = 2; i < nums.length - 1; i++) {
            int temp = profits[1];
            profits[1] = Math.max(nums[i] + profits[0], profits[1]);
            profits[0] = temp;
        }
        
        int firstProfits = profits[1];
        profits[0] = nums[1];
        profits[1] = Math.max(nums[2], nums[1]);

        for (int i = 3; i < nums.length; i++) {
            int temp = profits[1];
            profits[1] = Math.max(nums[i] + profits[0], profits[1]);
            profits[0] = temp;
        }

        return Math.max(firstProfits, profits[1]); 
    }
}
