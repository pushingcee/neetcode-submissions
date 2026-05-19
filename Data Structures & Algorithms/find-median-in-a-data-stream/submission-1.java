class MedianFinder {

    List<Integer> numbers;

    public MedianFinder() {
       numbers = new ArrayList();
    }
    
    public void addNum(int num) {
        numbers.add(num);
        Collections.sort(numbers);
    }
    
    public double findMedian() {
        // 1 3 3 5
        // 0 1 2 3
        // 1 3 3 5 6
        // 0 1 2 3 4 
        if (numbers.size() % 2 == 0) {
            int firstIndex = numbers.size() / 2;
            int prevIndex = firstIndex - 1;
            return ((double)numbers.get(firstIndex) + numbers.get(prevIndex))/2;
        } else {
            int mid = numbers.size() / 2;
            return numbers.get(mid);
        }
    }
}
