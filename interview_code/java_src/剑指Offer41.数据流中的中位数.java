class MedianFinder {
    // 本题思路：
    // 使用两个优先级队列。
    // 中位数是有序数组最中间的元素算出来的对吧，我们可以把「有序数组」抽象成一个倒三角形
    // 把这个大的倒三角形从正中间切成两半，变成一个小倒三角和一个梯形
    // 梯形中的最小宽度要大于等于小倒三角的最大宽度，这样它俩才能拼成一个大的倒三角
    // 小倒三角不就是个大顶堆嘛，梯形不就是个小顶堆嘛，中位数可以通过它们的堆顶元素算出来。
    // 维护「两个堆中的元素之差不能超过 1」，还要维护 large 堆的堆顶元素要大于等于 small 堆的堆顶元素。
    // 因为我们要求中位数嘛，假设元素总数是 n，如果 n 是偶数，我们希望两个堆的元素个数是一样的，这样把两个堆的堆顶元素拿出来求个平均数就是中位数；如果 n 是奇数，那么我们希望两个堆的元素个数分别是 n/2 + 1 和 n/2，这样元素多的那个堆的堆顶元素就是中位数。
    
    /** initialize your data structure here. */
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    public MedianFinder() {
        // 最小堆
        large = new PriorityQueue<>();
        // 最大堆
        small = new PriorityQueue<>((a, b) -> {return b - a;});
    }
    
    public void addNum(int num) {
        // 维护「两个堆中的元素之差不能超过 1」，还要维护 large 堆的堆顶元素要大于等于 small 堆的堆顶元素。
        if (small.size() >= large.size()) {
            // 如果插入的 num 小于 small 的堆顶元素，那么 num 就会留在 small 堆里，为了保证两个堆的元素数量之差不大于 1，作为交换，把 small 堆顶部的元素再插到 large 堆里。
            // 如果插入的 num 大于 small 的堆顶元素，那么 num 就会成为 samll 的堆顶元素，最后还是会被插入 large 堆中。
            // 先给多的那一堆，因为结果是多的那一堆数量没有改变，而少的那一堆多一个元素，所以这就是维护「两个堆中的元素之差不能超过 1」
            small.add(num);
            large.add(small.poll());
        } else {
            // 向 small 中插入元素是一个道理，这样就巧妙地保证了 large 堆整体大于 small 堆，且两个堆的元素之差不超过 1
            // 先给多的那一堆，因为结果是多的那一堆数量没有改变，而少的那一堆多一个元素，所以这就是维护「两个堆中的元素之差不能超过 1」
            large.add(num);
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2.0;        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */