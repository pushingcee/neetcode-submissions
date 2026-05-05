class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // alteranate to this map is the freq array.
        Map<String, List<String>> results = new HashMap<>();
        for (var str : strs) {
            String freqStrRepresentation = Arrays.toString(encodeAsFrequencyString(str));

            if(results.containsKey(freqStrRepresentation)) {
                results.get(freqStrRepresentation).add(str);
            } else {
                results.put(freqStrRepresentation, new ArrayList<>(List.of(str)));
            }
        }
        return new ArrayList<>(results.values());
    }

    private int[] encodeAsFrequencyString(String string){
        int[] freq = new int[26];
        for(var entry : string.toCharArray()) {
        freq[entry - 'a']++;
        }
        return freq;
    }
}
