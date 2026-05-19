class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int transfer = maxHeap.poll();
                minHeap.offer(transfer);
        }
            
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }
    
    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            Integer minHeapResult = minHeap.peek();
            Integer maxHeapResult = maxHeap.peek();
            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        } 
        else {
            return maxHeap.peek();
        }
    }
}
