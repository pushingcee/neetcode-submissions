public class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        int minCoins = dfs(amount, coins, memo);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public int dfs(int amount, int[] coins,Map<Integer, Integer> memo) {
        if(amount == 0) {
            return 0;
        }

        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int res = Integer.MAX_VALUE;

        for(var coin : coins) {
            if(amount - coin >= 0) {
                int result = dfs(amount - coin, coins, memo);
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result);
                }
            }
        }

        memo.put(amount, res);
        return res;
    }    
}