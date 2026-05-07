class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0 || s.length() == k || s.length() < k) {
            return s.length();
        }

        int left = 0, maxFreq = 0, max = 0;
        int right = 0;
        int[] freq = new int[26];

        while(right < s.length()) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
