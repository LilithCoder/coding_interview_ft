class Solution {
    // 本题思路：
    // 用哈希表存储单词及其出现的次数
    // 再堆排序：先按照出现次数从大到小排序，如果次数相同，则根据字典序排序
    // 然后将排序过后的前k个高频单词加入res
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> word_count = new HashMap<>();
        // 单词及其出现的次数
        for (String word: words) {
            word_count.put(word, word_count.getOrDefault(word, 0) + 1);
        }
        // 堆排序：先按照出现次数从大到小排序，如果次数相同，则根据字典序排序
        PriorityQueue<String> pqueue = new PriorityQueue<>((word1, word2) -> {
            if (word_count.get(word1) == word_count.get(word2)) {
                return word1.compareTo(word2);
            } else {
                return word_count.get(word2) - word_count.get(word1);
            }
        });
        for (String word: word_count.keySet()) {
            pqueue.add(word);
        }
        List<String> res = new ArrayList<>();
        // 将排序过后的前k个高频单词加入res
        for (int i = 0; i < k; i++) {
            res.add(pqueue.poll());
        }
        return res;
    }
}