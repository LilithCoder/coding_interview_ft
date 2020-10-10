class Solution {
    // 本题思路：
    // 在哈希表的基础上，有序哈希表中的键值对是 按照插入顺序排序 的。基于此，可通过遍历有序哈希表，实现搜索首个 “数量为 1 的字符”。
    public char firstUniqChar(String s) {
        char res = ' ';
        if (s == null || s.length () == 0) return res;
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char curr = chs[i];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        for (char key: map.keySet()) {
            if (map.get(key) == 1) {
                res = key;
                break;
            }
        }
        return res;
    }
}