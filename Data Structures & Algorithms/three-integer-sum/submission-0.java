class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = nums[i];
            int nextIndex = i + 1;
            int endIndex = nums.length - 1;
            while(nextIndex < endIndex) {
                int additionResult = nums[nextIndex] + nums[endIndex] + target;
                if(additionResult == 0) {
                    result.add(List.of(target, nums[nextIndex], nums[endIndex]));
                    while(nextIndex < endIndex && nums[nextIndex] == nums[nextIndex + 1]) nextIndex++;
                    while(nextIndex < endIndex && nums[endIndex] == nums[endIndex - 1]) endIndex--;
                    nextIndex++;
                    endIndex--;
                } else if (additionResult > 0) {
                    endIndex--;
                } else {
                    nextIndex++;
                }
            }
        }
        return result;
    }
}