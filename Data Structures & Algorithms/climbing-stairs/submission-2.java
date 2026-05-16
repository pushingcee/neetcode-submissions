class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> resmap = new HashMap();
        resmap.put(1, 1);
        resmap.put(2, 2);
        return climbStairs(n, resmap);
    }

    public int climbStairs(int n, Map<Integer, Integer> resmap) {
        if (n == 1) {
            return 1;
        }    
        if (n == 2) {
            return 2;
        }

        if(resmap.containsKey(n)) {
            return resmap.get(n);
        }

        int result =  climbStairs(n - 1, resmap) + climbStairs(n - 2, resmap);
        resmap.put(n, result);
        
        return result;
    }


}
