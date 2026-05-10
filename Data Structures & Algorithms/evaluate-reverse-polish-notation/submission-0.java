class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for(String character : tokens) {

            if (operators.contains(character)) {

                int secondOperand = deque.removeFirst();
                int firstOperand = deque.removeFirst();
                deque.addFirst(applyOperation(firstOperand, secondOperand, character));

            } else {
                deque.addFirst(Integer.valueOf(character));
            }
        }

        return deque.removeFirst();
    }

    private int applyOperation(int firstOperand, int secondOperand, String operation) {
        if (operation.equals("-")) {
            return firstOperand - secondOperand;
        } 

        if (operation.equals("+")) {
            return firstOperand + secondOperand;
        }

        if (operation.equals("*")) {
            return firstOperand * secondOperand;
        }
            
        return firstOperand / secondOperand;
    }
}
