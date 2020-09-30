class Solution {
    // 本题思路：
    // 扫描整个段落，如果遇到一个非字母的符号，那就把之前遇到的字母作为一个单词。
    // 遇到字母的时候，切换小写，并加入word
    // 更新是否是最常见的单词
    public String mostCommonWord(String paragraph, String[] banned) {
        // 加个非字母符号，为了字符串最后没有非字母字符来作为word的判断的时候
        paragraph += ".";
        // 禁词加入hashset，方便快速查找
        Set<String> stopwords = new HashSet<>();
        for (String word: banned) {
            stopwords.add(word);
        }
        Map<String, Integer> map = new HashMap<>();
        int max_count = 0;
        String result = "";
        StringBuilder word = new StringBuilder();
        // 扫描整个段落，如果遇到一个非字母的符号，那就把之前遇到的字母作为一个单词。
        for (char ch: paragraph.toCharArray()) {
            if (Character.isLetter(ch)) {
                // 遇到字母的时候，切换小写，并加入word
                word.append(Character.toLowerCase(ch));
            } else {
                if (word.length() > 0) {
                    String word_str = word.toString();
                    if (!stopwords.contains(word_str)) {
                        // 将之前的那个单词加入计数
                        map.put(word_str, map.getOrDefault(word_str, 0) + 1);
                        // 更新是否是最常见的单词
                        if (map.get(word_str) > max_count) {
                            max_count = map.get(word_str);
                            result = word_str;
                        }
                    }
                }
                word = new StringBuilder();
            }
        }
        return result;
    }
}