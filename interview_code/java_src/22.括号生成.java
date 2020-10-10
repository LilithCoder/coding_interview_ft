class Solution {
    // 本题思路：
    // 其实就是回溯算法，只不过加了一些限定条件
    // 选择列表为'('和')'
    // 限定条件为添加开括号的条件为开括号还不够，添加闭括号的条件为闭括号数量小于开括号数量
    // track完成的条件为长度为n*2
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder track = new StringBuilder();
        backtrack(res, 0, 0, n, track);
        return res;
    }
    public void backtrack(List<String> res, int open, int close, int n, StringBuilder track) {
        if (track.length() == n * 2) {
            res.add(track.toString());
            return;
        }
        // 开括号如果还不够，加一个开括号
        if (open < n) {
            track.append('(');
            backtrack(res, open + 1, close, n, track);
            track.deleteCharAt(track.length() - 1);
        }
        // 如果闭括号数量小于开括号数量，加一个闭括号
        if (close < open) {
            track.append(')');
            backtrack(res, open, close + 1, n, track);
            track.deleteCharAt(track.length() - 1);
        }
    }
}