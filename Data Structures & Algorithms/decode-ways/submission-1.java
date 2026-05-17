class Solution {
    public int numDecodings(String s) {
        Map<String, Integer> memo = new HashMap<>();
        return decode(s, memo);
    }

    public int decode(String s, Map<String, Integer> memo) {
        if(s.isEmpty()){
            return 1;
        }

        if (s.startsWith("0")) {
            return 0;
        }

        if(memo.containsKey(s)) {
            return memo.get(s);
        }


        int ways = 0;
        
        //try to decode start? 
        //then pass remainder without start
        //if there's even one zero, I have to set ways to zero and end; 

        ways += decode(s.substring(1), memo);

        if(s.length() >= 2) {
            if(Integer.valueOf(s.substring(0, 2)) <= 26) {
                ways += decode(s.substring(2), memo);
            }
        }

        memo.put(s, ways);

        return ways;
    }
}
