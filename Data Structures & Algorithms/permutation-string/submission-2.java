class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // build s1Freq
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        // build initial window
        for (int i = 0; i < s1.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // slide
        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(s1Freq, windowFreq)) return true;
            windowFreq[s2.charAt(i) - 'a']++;              // add right
            windowFreq[s2.charAt(i - s1.length()) - 'a']--; // remove left
        }

        return Arrays.equals(s1Freq, windowFreq);
    }
}
