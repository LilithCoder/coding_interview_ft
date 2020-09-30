class Solution {
    // 本题思路：
    // 将问题抽象在一个无向无权图中，每个单词作为节点，差距只有一个字母的两个单词之间连一条边。
    // 问题变成找到从起点到终点的最短路径，如果存在的话。因此可以使用广度优先搜索方法
    // 解决的关键：用储存在哈希表的单词通用状态来方便找出相邻的只差一个字母的单词
    class Pair {
        private String word;
        private int level;
        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 每个wordList里的单词都生成通用状态。
        // 举例：1.Dug => *ug 
        //      2.Dug => D*g 
        //      3.Dug => Du*
        // 将(单词的某一通用状态，合适这一通用状态的所有单词)存储在哈希表
        // 这样可以方便找出相邻的节点，也就是只差一个字母的两个单词
        Map<String, List<String>> comb_dict = new HashMap<>();
        int n = beginWord.length();
        for (String word: wordList) {
            // 对于每一单词，将所有可能的通用状态存入哈希表
            for (int i = 0; i < n; i++) {
                String general_word = word.substring(0, i) + "*" + word.substring(i + 1, n);
                List<String> word_list = comb_dict.getOrDefault(general_word, new ArrayList<String>());
                word_list.add(word);
                comb_dict.put(general_word, word_list);
            }   
        }
        // bfs
        // (单词，单词出现的level)
        Queue<Pair> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                String curr_word = curr.word;
                int curr_level = curr.level;
                // 遍历curr_word所有的相邻单词，也就是只差一个字母的单词
                for (int j = 0; j < n; j++) {
                    String general_word = curr_word.substring(0, j) + "*" + curr_word.substring(j + 1, n);
                    for (String adj_word: comb_dict.getOrDefault(general_word, new ArrayList<String>())) {
                        if (adj_word.equals(endWord)) return curr_level + 1;
                        if (!visited.contains(adj_word)) {
                            queue.add(new Pair(adj_word, curr_level + 1));
                            visited.add(adj_word);
                        }
                    }
                }
            }
        }
        return 0;
    }
}