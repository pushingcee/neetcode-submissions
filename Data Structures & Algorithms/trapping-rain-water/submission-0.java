class Solution {
    public int trap(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int capacity = 0;
        int maxLeft = 0, maxRight = 0;
        while(leftIndex < rightIndex) {
            if(height[leftIndex] <= height[rightIndex]) {
                maxLeft = Math.max(maxLeft, height[leftIndex]);
                capacity += maxLeft - height[leftIndex];
                leftIndex++;
            } else {
                maxRight = Math.max(maxRight, height[rightIndex]);
                capacity += maxRight - height[rightIndex];
                rightIndex--;
            }
        }
        return capacity;
    }
}
