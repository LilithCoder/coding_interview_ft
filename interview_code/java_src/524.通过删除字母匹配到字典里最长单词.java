class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest_word = "";
        for (String target: d) {
            int l1 = longest_word.length();
            int l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longest_word.compareTo(target) < 0)) {
                continue;
            }
            if (is_substr(s, target)) {
                longest_word = target;
            }
        }
        return longest_word;
    }
    private boolean is_substr(String s, String sub_str) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < sub_str.length()) {
            if (s.charAt(i) == sub_str.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub_str.length();
    }
}