class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>(); 
        getCombination(output, target, 0, 0, new ArrayList<Integer>(), nums);
        return output;
    }

    public void getCombination(List<List<Integer>> result, int target, int currentSum, int index, List<Integer> aggregated, int[] nums) {
        if (currentSum == target) {
            result.add(new ArrayList<>(aggregated));
            return;
        }

        if(currentSum > target) {
            return;
        }

        if (index > nums.length - 1){
            return;
        }

        aggregated.add(nums[index]);
        getCombination(result, target, currentSum + nums[index], index, aggregated, nums);
        aggregated.removeLast();
        getCombination(result, target, currentSum, index + 1, aggregated, nums);
    }
}
