class Solution {
    // 本题思路：
    // 纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，
    // 如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int n = strs[0].length();
        for (int i = 0; i < n; i++) {
            char curr = strs[0].charAt(i);
            for (String str: strs) {
                if (i == str.length() || curr != str.charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}