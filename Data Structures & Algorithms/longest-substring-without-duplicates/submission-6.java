class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        String[] chars = s.split("");
        Set<String> occurences = new HashSet<String>();
        int max = 0;
        int currentMax = 0;
        for(int i = 0; i < chars.length; i++) {
            for(int j = i; j < chars.length; j++) { 
                if(occurences.add(chars[j]) == true) { //a, a 
                    currentMax += 1; //1
                    max = Math.max(currentMax, max); //2 
                } else {
                    occurences = new HashSet<String>();
                    max = Math.max(currentMax, max);
                    currentMax = 0;
                    break;
                }
            }
        }
        return max;
    }
}
