class Solution {
    // 双向且单调的队列 队头 <- 队尾 单调增大
    class MonotonicQueue {
        private ArrayDeque<Integer> deque;
        public MonotonicQueue() {
            deque = new ArrayDeque<>();
        }
        public int max() {
            return deque.peekFirst();
        }
        public void pop(int n) {
            if (!deque.isEmpty() && n == deque.peekFirst()) deque.pollFirst();
        }
        public void push(int n) {
            while (!deque.isEmpty() && deque.peekLast() < n) {
                deque.pollLast();
            }
            deque.addLast(n);
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 填满窗口前k-1
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}