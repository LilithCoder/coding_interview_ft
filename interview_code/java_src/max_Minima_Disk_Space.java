// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：计算出所有segment最少硬盘空间的最大值
    // 双向且单调的队列 队头 <- 队尾 单调减小
    static class MonotonicQueue {
        private ArrayDeque<Integer> deque;
        public MonotonicQueue() {
            deque = new ArrayDeque<>();
        }
        public int min() {
            return deque.peekFirst();
        }
        public void pop(int n) {
            if (!deque.isEmpty() && n == deque.peekFirst()) deque.pollFirst();
        }
        public void push(int n) {
            while (!deque.isEmpty() && deque.peekLast() > n) {
                deque.pollLast();
            }
            deque.addLast(n);
        }
    }
    
    public static int maxMinimaDiskSpace(int numComputer, ArrayList<Integer> hardDiskSpace, int segmentLength) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> minima_disk = new ArrayList<>();
        for (int i = 0; i < numComputer; i++) {
            // 填满窗口前k-1
            if (i < segmentLength - 1) {
                window.push(hardDiskSpace.get(i));
            } else {
                window.push(hardDiskSpace.get(i));
                minima_disk.add(window.min());
                window.pop(hardDiskSpace.get(i - segmentLength + 1));
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i: minima_disk) {
            result = Math.max(result, i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int numComputer = 3;
        ArrayList<Integer> hardDiskSpace = new ArrayList<>(List.of(8, 2, 4));
        int segmentLength = 2;
        // 期望输出：2
        System.out.println("输出：" + maxMinimaDiskSpace(numComputer, hardDiskSpace, segmentLength));
    }
}