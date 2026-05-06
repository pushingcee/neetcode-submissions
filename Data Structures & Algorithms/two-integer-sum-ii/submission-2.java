class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        while(startIndex < endIndex) {
            if(numbers[startIndex] + numbers[endIndex] == target) {
                return new int[]{startIndex + 1, endIndex + 1};
            } 
            
            if(numbers[startIndex] + numbers[endIndex] > target ) {
                endIndex--;
            } else {
                startIndex++;
            }

        }
        return new int[]{};
    }
}
