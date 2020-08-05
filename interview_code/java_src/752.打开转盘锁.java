/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    // 将 s[j] 向上拨动一次
    private String plus_one(String s, int i) {
        char[] chs = s.toCharArray();
        if (chs[i] == '9') {
            chs[i] = '0';
        } else {
            chs[i]++;
        }
        return String.valueOf(chs);
    }
    // 将 s[i] 向下拨动一次
    private String minus_one(String s, int i) {
        char[] chs = s.toCharArray();
        if (chs[i] == '0') {
            chs[i] = '9';
        } else {
            chs[i]--;
        }
        return String.valueOf(chs);
    }
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        q.add("0000");
        visited.add("0000");
        for (String dead: deadends) deads.add(dead);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.remove();
                /* 跳过死亡密码 */
                if (deads.contains(curr)) continue;
                /* 判断是否到达终点 */
                if (curr.equals(target)) return step;
                /* 将一个节点的未遍历相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String up = plus_one(curr, j);
                    if (!visited.contains(up)) {
                        q.add(up);
                        visited.add(up);
                    }
                    String down = minus_one(curr, j);
                    if (!visited.contains(down)) {
                        q.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
// @lc code=end

