class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        Map<Character, Character> closerOpenerPair = Map.of(')', '(', ']', '[', '}', '{');

        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
           if (!closerOpenerPair.containsKey(current)) {
                // means we've got an opener
                arrayDeque.addFirst(current);
           } else {
                
                if(arrayDeque.isEmpty()) {
                    return false;
                }

                Character last = arrayDeque.removeFirst();

                if(last != closerOpenerPair.get(current)) {
                    return false;
                }
           }
        }

        return arrayDeque.isEmpty();
    }
}
