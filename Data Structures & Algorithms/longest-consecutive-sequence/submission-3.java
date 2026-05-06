
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int longest = 1;
        int current = 1;


        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] == nums[i]) continue; // skip duplicates
           if(nums[i + 1] == nums[i] + 1){
            current++;
            longest = Math.max(current, longest);
           } 
           if(nums[i + 1] > nums[i] + 1) {
            current = 1;
           }
        }

        return longest;
        
    }
}
