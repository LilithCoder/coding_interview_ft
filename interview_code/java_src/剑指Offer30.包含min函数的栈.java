class MinStack {
    // 本题思路：
    // 需要设计一个数据结构，使得每个元素 a 与其相应的最小值 m 时刻保持一一对应。因此我们可以使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值。
    // 当一个元素要入栈时，我们取当前辅助栈的栈顶存储的最小值，与当前元素比较得出最小值，将这个最小值插入辅助栈中；
    // 当一个元素要出栈时，我们把辅助栈的栈顶元素也一并弹出；
    // 在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中。
    /** initialize your data structure here. */
    Stack<Integer> main_stack;
    Stack<Integer> helper_stack;
    public MinStack() {
        main_stack = new Stack<>();
        helper_stack = new Stack<>();
        helper_stack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        main_stack.push(x);
        if (x < helper_stack.peek()) {
            helper_stack.push(x);
        } else {
            helper_stack.push(helper_stack.peek());
        }
    }
    
    public void pop() {
        main_stack.pop();
        helper_stack.pop();
    }
    
    public int top() {
        return main_stack.peek();
    }
    
    public int min() {
        return helper_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */