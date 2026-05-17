class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        return dfs(s, wordDict, memo);
    }

    public boolean dfs(String s, List<String> wordDict, Map<String, Boolean> memo) {  
        if(s.equals("")) {
            return true;
        }

        if(memo.containsKey(s)) {
            return false;
        }

        for(var word : wordDict) {
            if (s.startsWith(word)) {
                String shortened = s.substring(word.length(), s.length());
                if (dfs(shortened, wordDict, memo)) {
                    return true;
                }
            }
        }

        memo.put(s, false);

        return false;
    }
}
