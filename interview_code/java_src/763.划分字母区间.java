class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        
        // 定义数组 last[char] 来表示字符 char 最后一次出现的下标。
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        
        // 定义 anchor 和 j 来表示当前区间的首尾。
        int anchor = 0;
        int j = 0;
        
        for (int i = 0; i < S.length(); i++) {
            // 如果遇到的字符最后一次出现的位置下标大于 j， 就让 j=last[c] 来拓展当前的区间。
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                // 当遍历到了当前区间的末尾时(即 i==j )，把当前区间加入答案
                res.add(j - anchor + 1);
                // 将 start 设为 i+1 去找下一个区间
                anchor = j + 1;
            }
        }
        return res;
    }
}