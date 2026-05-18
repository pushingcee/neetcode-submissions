class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        return decode(s, 0, memo);
    }

    public int decode(String s, int cutIndex, Map<Integer, Integer> memo) {
        if (cutIndex >= s.length()) {
            return 1;
        } 

        if (s.charAt(cutIndex) == '0') {
            return 0;
        }       

        if (memo.containsKey(cutIndex)) {
            return memo.get(cutIndex);
        }

        int ways = 0;

        ways += decode(s, cutIndex + 1, memo);
        
        if(s.length() - cutIndex >= 2) {
            if(s.charAt(cutIndex) == '1' || (s.charAt(cutIndex) =='2' && s.charAt(cutIndex + 1) <= '6')) {
                ways += decode(s, cutIndex + 2, memo);
            }
        }

        memo.put(cutIndex, ways);

        return ways;
    }
}
