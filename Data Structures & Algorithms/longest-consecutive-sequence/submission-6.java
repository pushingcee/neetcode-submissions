class Solution {
public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;
    
    Set<Integer> occurrences = new HashSet<>();
    for (int i = 0; i < nums.length; i++)
        occurrences.add(nums[i]);

    int max = 0;
    for (var num : occurrences) {
        if (!occurrences.contains(num - 1)) {
            int length = 1;
            while (occurrences.contains(num + length))
                length++;
            max = Math.max(max, length);
        }
    }
    return max;
}
}
