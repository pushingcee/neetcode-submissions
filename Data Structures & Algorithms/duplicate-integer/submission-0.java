class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int numberCount = nums.length;
        for (int num : nums) {
            if (!seen.add(num)) return true;
        }
        return false;
    }
}