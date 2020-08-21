class LRUCache {
    
    class Node {
        public int key;
        public int val;
        public Node next;
        public Node prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    
    class DoubleList {
        // 头尾结点
        private Node head;
        private Node tail;
        // 链表元素数
        private int size;
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        // 在链表尾部添加结点x
        // 每次默认从链表尾部添加元素，那么显然越靠尾部的元素就是最近使用的，越靠头部的元素就是最久未使用的。
        // 我们实现的双链表 API 只能从尾部插入，也就是说靠尾部的数据是最近使用的，靠头部的数据是最久为使用的。
        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }
        
        // 删除链表中的 x 节点（x 一定存在）
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }
        
        // 删除链表中第一个节点，并返回该节点
        public Node removeFirst() {
            if (head.next == null) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }
        
        // 返回链表长度
        public int size() { return size; }
    }

    // key -> Node(key, val)
    private Map<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)
    private DoubleList cache;
    // 最大容量
    private int cap;
    
    // 在 LRU 算法中把双向链表和哈希表结合起来
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        makeRecently(key);
        return map.get(key).val;
    }
    
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, val);
            return;
        }
        if (cap == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, val);
    }
    
    // 将某个 key 提升为最近使用的
    private void makeRecently(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }
    // 添加最近使用的元素
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        // 链表尾部就是最近使用的元素
        cache.addLast(x);
        // map 中添加 key 的映射
        map.put(key, x);
    }
    // 删除某一个 key
    private void deleteKey(int key) {
        Node x = map.get(key);
        // 从链表中删除
        cache.remove(x);
        // 从 map 中删除
        map.remove(key);
    }
    // 删除最久未使用的元素
    private void removeLeastRecently() {
        // 链表头部的第一个元素就是最久未使用的
        Node deletedNode = cache.removeFirst();
        // 从 map 中删除它的 key
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */