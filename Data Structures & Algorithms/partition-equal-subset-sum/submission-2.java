class Solution {
    public boolean canPartition(int[] nums) {
        Map<String, Boolean> memo = new HashMap<>();
        int sum = 0;
        for(var num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) { 
            return false;
        }

        return iterate(nums, 0, sum/2, memo);
    }

    private boolean iterate(int[] nums, int index, int remainder, Map<String, Boolean> memo) {
        if(remainder == 0) {
            return true;
        }

        if(remainder < 0 || index == nums.length) {
            return false;
        }
        
        String key = index + "#" + remainder;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean canDivide = iterate(nums, index + 1, remainder, memo) || //without current index
            iterate(nums, index + 1, remainder - nums[index], memo);

        memo.put(key, canDivide);

        return canDivide;
    }
}
