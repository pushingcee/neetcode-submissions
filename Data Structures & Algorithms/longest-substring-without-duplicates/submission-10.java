class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }

        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = left;
        int max = 0;

        for(right = 0; right < s.length(); right++) {
            while(window.contains(s.charAt(right))){
                window.remove(s.charAt(left));
                left++;
            } 
            window.add(s.charAt(right));
            max = Math.max(window.size(), max);
        }

        return max;
    }
}