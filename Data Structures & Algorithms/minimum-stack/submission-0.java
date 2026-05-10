class MinStack {

    ArrayDeque<Integer> stack;
    ArrayDeque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.addFirst(val);
        int currentMinimum = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peekFirst();
        minStack.addFirst(Math.min(currentMinimum, val));
        //return the MinStack if I had the freedom :) just for the testing/compose 
    }
    
    public void pop() {
        stack.removeFirst();
        // currentMinimum = Math.min(currentMinimum, val);
        minStack.removeFirst();
        //return the MinStack if I had the freedom :) just for the testing/compose 
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();
    }
}
