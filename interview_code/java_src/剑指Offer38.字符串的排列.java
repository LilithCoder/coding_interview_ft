class Solution {    
    // 本题思路：
    // 全排列II
    // 字符数组里有重复的元素，需要去重
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder track = new StringBuilder();
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        boolean[] visited = new boolean[chs.length];
        backtrack(chs, res, track, visited);
        return res.toArray(new String[res.size()]);
    }
    public void backtrack(char[] chs, List<String>res, StringBuilder track, boolean[] visited) {
        if (track.length() == chs.length) {
            res.add(track.toString());
            return;
        }
        for (int i = 0; i < chs.length; i++) {
            if (visited[i]) continue;
            // 如果这个数和之前的数一样，并且之前的数还未使用过（说明已经回溯过）
            if (i > 0 && chs[i] == chs[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            track.append(chs[i]);
            backtrack(chs, res, track, visited);
            track.deleteCharAt(track.length() - 1);
            visited[i] = false;
        }
    }
}