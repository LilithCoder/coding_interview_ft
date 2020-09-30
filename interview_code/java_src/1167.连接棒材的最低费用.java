class Solution {
    // 本题思路：
    // 贪心算法：将所有值都加入到优先队列。每次从优先队列中取出两个数相加
    // 然后将相加的值再加入到优先队列，不断重复这个过程，直到优先队列只剩下一个元素为止
    // 产生的费用就是最小费用
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) return 0;
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        for (int stick: sticks) {
            min_heap.add(stick);
        }
        int res = 0;
        while (min_heap.size() >= 2) {
            Integer first = min_heap.poll();
            Integer second = min_heap.poll();
            res += (first + second);
            min_heap.add(first + second);
        }
        return res;
    }
}