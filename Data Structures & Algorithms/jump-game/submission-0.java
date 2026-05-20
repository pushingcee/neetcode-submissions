class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        //[1,2,1,0,1]
        // 0 -> 1, 
        for (int i = 0; i < nums.length; i++) {
            if(i > maxReachable ) {
                return false;
            }
            maxReachable = Math.max(nums[i] + i, maxReachable);
        }

        return true;
    }
}
