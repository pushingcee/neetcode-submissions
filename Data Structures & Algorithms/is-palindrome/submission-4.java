class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1) {
            return true;
        }
        char[] lowercased = s.toLowerCase().toCharArray();
        int start = 0;
        int end = lowercased.length - 1;
        while(start < end) {
            while(!Character.isLetterOrDigit(lowercased[start]) && start < end){
                start++;
            }
            while(!Character.isLetterOrDigit(lowercased[end]) && end > start){
                end--;
            }

            if(lowercased[start] != lowercased[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
