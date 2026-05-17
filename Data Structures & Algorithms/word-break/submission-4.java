class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> memo = new HashSet<>();
        return dfs(s, wordDict, memo);
    }

    public boolean dfs(String s, List<String> wordDict, Set<String> memo) {  
        if(s.equals("")) {
            return true;
        }

        if(memo.contains(s)) {
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

        memo.add(s);

        return false;
    }
}
