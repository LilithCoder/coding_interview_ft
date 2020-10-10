class Solution {
    // 本题思路：
    // 每个字符串排序作为key，依次加入map
    // 直接输出每个key对应的字母异位词list即可
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String new_str = String.valueOf(chs);
            map.putIfAbsent(new_str, new ArrayList<>());
            map.get(new_str).add(str);
        }
        return new ArrayList<>(map.values());
    }
}