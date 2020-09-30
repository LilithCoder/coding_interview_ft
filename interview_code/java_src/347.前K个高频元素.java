class Solution {
    // 本题思路：
    // 跟lc#692.前K个高频单词基本一样
    // 用哈希表存储单词及其出现的次数
    // 再堆排序：先按照出现次数从大到小排序
    // 然后将排序过后的前k个高频单词加入res
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> {
            return map.get(b) - map.get(a);
        });
        for (int key: map.keySet()) {
            max_heap.add(key);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = max_heap.poll();
        }
        return res;
    }
}