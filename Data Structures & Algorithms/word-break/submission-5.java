class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> memo = new HashSet<>();
        return dfs(s, wordDict, memo, 0);
    }

    public boolean dfs(String s, List<String> wordDict, Set<Integer> memo, int start) {
        if (start == s.length()) return true;

        if (memo.contains(start)) return false;

        for (var word : wordDict) {
            if (s.startsWith(word, start)) {
                if (dfs(s, wordDict, memo, start + word.length())) {
                    return true;
                }
            }
        }

        memo.add(start);
        return false;
    }
}