class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        String[] chars = s.split("");
        Set<String> occurences = new HashSet<String>();
        int max = 0;
        int currentMax = 0;
        int left = 0;
        int right = 0;
        //abcabcbb
        while(left <= right && right < chars.length) {
            if(occurences.add(chars[right])){
                currentMax = right - left + 1;
                max = Math.max(currentMax, max);
                right++;
            } else {
                occurences.remove(chars[left]);
                left++;
            }
        }

        return max;
    }
}