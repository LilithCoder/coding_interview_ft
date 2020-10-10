class Trie {
    // 本题思路：
    // 一个前缀树是用来 存储字符串 的。前缀树的每一个节点代表一个 字符串（前缀）。
    // 每一个节点会有多个子节点，通往不同子节点的路径上有着不同的字符。
    // 子节点代表的字符串是由节点本身的 原始字符串 ，以及 通往该子节点路径上所有的字符 组成的。
    class TrieNode {
        public boolean isWord;
        public HashMap<Character, TrieNode> children = new HashMap<>();
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children.get(ch) == null) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (curr.children.get(ch) == null) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */