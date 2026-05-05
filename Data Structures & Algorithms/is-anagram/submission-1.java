class Solution {
    public boolean isAnagram(String s, String t) {
                if (s.length() != t.length()) {
           return false;
        }
        String[] firstLetters = s.split("");
        Map<String, Integer> ogLetterSet = new HashMap<>();

        for(var letter: firstLetters) {
            if (ogLetterSet.containsKey(letter)) {
                ogLetterSet.computeIfPresent(letter, (k, v) -> v.intValue() + 1);
            } else {
                ogLetterSet.put(letter, 1);
            }
        }

        for (String letter : t.split("")){
            if (ogLetterSet.containsKey(letter)) {
                int value = ogLetterSet.get(letter) - 1;

                if(value < 0) {
                    return false;
                }

                ogLetterSet.compute(letter, (k, v) -> value);
            } else {
                return false;
            }
        }
        return true;
    }
}
