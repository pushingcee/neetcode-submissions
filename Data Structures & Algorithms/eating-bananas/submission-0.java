class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minAmount = 1;
        int maxAmount = 0;
        for (int i = 0; i < piles.length; i++) {
            maxAmount = Math.max(piles[i], maxAmount);
        }

        while(minAmount < maxAmount) {
            int hoursSpent = 0;
            int middle = (minAmount + maxAmount)/2;

            for(var pile : piles) {
                hoursSpent += Math.ceil((double)pile / middle);
            }

            if(hoursSpent <= h) {
                maxAmount = middle;
            } else {
                minAmount = middle + 1;
            }
        }

        return minAmount;

    }
}
