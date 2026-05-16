class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int profits[] = new int[nums.length];
        //setup base case
        profits[0] = nums[0];
        profits[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // 2 9 10 12 16
            profits[i] = Math.max(nums[i] + profits[i - 2], profits[i - 1]);
        }

        return profits[nums.length - 1];

    }
}
