class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> memo = new HashSet<>();
        return dfs(s, wordDict, memo, 0);
    }

    public boolean dfs(String s, List<String> words, Set<Integer> memo, int start) {
        if (start > s.length()) {
            return false;
        }

        if (start == s.length()) {
            return true;
        }

        if (memo.contains(start)) {
            return false;
        }

        for (var word : words) {
            if (s.startsWith(word, start)) {
                if (dfs(s, words, memo, start + word.length())) {
                    return true;
                }
            }
        }

        memo.add(start);
        return false;
    }
}