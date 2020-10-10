class Solution {
    // 本题思路：
    // 字符串排个序，对比下就行
    public boolean isAnagram(String s, String t) {
        char[] temp1 = s.toCharArray();
        char[] temp2 = t.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        return String.valueOf(temp1).equals(String.valueOf(temp2));
    }
}