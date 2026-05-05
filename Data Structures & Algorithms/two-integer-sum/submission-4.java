class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> compIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int targetRemainder = target - nums[i];
            if(compIndexMap.containsKey(nums[i])) {
                return new int[]{compIndexMap.get(nums[i]), i};
            } else {
                compIndexMap.put(targetRemainder, i);
            }
        }
        return new int[]{};
    }
}
