class Solution {
public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;
    
    Set<Integer> occurrences = new HashSet<>();
    for (int i = 0; i < nums.length; i++)
        occurrences.add(nums[i]);

    int max = 1;
    for (int i = 0; i < nums.length; i++) {
        if (occurrences.contains(nums[i] - 1)) {
            int length = 2;
            while (occurrences.contains(nums[i] + length - 1))
                length++;
            max = Math.max(max, length);
        }
    }
    return max;
}
}
