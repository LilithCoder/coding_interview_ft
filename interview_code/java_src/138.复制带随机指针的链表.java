/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // 本题思路：
    // 用哈希表存储访问过的结点，key为原结点，value为deepcopy的结点
    // 在迭代链表时，我们只需要为 random 指针和 next 指针指向的未访问过节点创造新的节点并赋值即可。
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node curr = head;
        // 用哈希表存储旧结点和新结点的映射
        Map<Node, Node> map = new HashMap<>();
        while (curr != null) {
            Node clone = new Node(curr.val);
            map.put(curr, clone);
            curr = curr.next;
        }
        curr = head;
        // 指针
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}