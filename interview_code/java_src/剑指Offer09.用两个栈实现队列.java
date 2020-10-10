class CQueue {
    // 本题思路：
    // 维护两个栈 stack1 和 stack2，其中 stack1 支持插入操作，stack2 支持删除操作
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        // stack1 直接插入元素
        stack1.push(value);
    }
    
    public int deleteHead() {
        // 如果 stack2 为空，则将 stack1 里的所有元素弹出插入到 stack2 里
        // 如果 stack2 仍为空，则返回 -1，否则从 stack2 弹出一个元素并返回
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */