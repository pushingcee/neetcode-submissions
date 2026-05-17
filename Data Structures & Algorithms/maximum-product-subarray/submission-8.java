class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int maxProd = nums[0], minProd = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            int tempMin = Math.min(nums[i], Math.min(maxProd * nums[i], minProd * nums[i]));
            maxProd = Math.max(tempMax, tempMin);
            minProd = Math.min(tempMax, tempMin);
            result = Math.max(tempMax, result);
        }

        return result;
    }
}
