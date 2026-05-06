class Solution {
    public int maxArea(int[] heights) {
        int startIndex = 0;
        int endIndex = heights.length - 1;
        int maxCapacity = 0;
        
        while(startIndex < endIndex) {
            int lesser = Math.min(heights[startIndex], heights[endIndex]); //if startIndex > endIndex ternary
            int containerLength = endIndex - startIndex; //possible edge/boundary check later
            int currentCapacity = lesser * containerLength;
            maxCapacity = Math.max(maxCapacity, currentCapacity);
            //which index to move? use lesser
            if(heights[startIndex] <= heights[endIndex]){
                startIndex++;
            } else {
                endIndex--;
                }
            }

        return maxCapacity;
    }
}
