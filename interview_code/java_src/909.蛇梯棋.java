class Solution {
    // 本题思路：
    // 用bfs解决，当因为梯子或者蛇重回之前的格子并且发现该格子已经有最少移动次数的时候，则不再bfs这个格子
    // 因为移动次数一定比原先的多，第一次遍历到该格子的移动次数一定是最少的
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int N = board.length;
        
        // 用哈希表存储方格编号->最少需要移动的次数
        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(1, 0);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int s1 = queue.poll();
                if (s1 == N * N) return dist.get(s1);
                for (int j = s1 + 1; j <= Math.min(N * N, s1 + 6); j++) {
                    int row = get_coord(j, N)[0];
                    int col = get_coord(j, N)[1];
                    // s2如果为-1，则保持，否则跳转到指定的方格
                    int s2 = board[row][col] == -1 ? j : board[row][col];
                    // 因为梯子或者蛇重回之前的格子并且发现该格子已经有最少移动次数的时候，则不再bfs这个格子
                    // 第一次遍历到该格子的移动次数一定是最少的
                    if (!dist.containsKey(s2)) {
                        dist.put(s2, dist.get(s1) + 1);
                        queue.add(s2);
                    }
                }
            }
        }
        return -1;
    }
    
    // 返回指定格子的坐标
    public int[] get_coord(int num, int N) {
        int row = N - 1 - (num - 1) / N;
        // 判断row，来决定col
        int col = (N - 1 - row) % 2 == 0 ? (num - 1) % N : N - 1 - (num - 1) % N;
        return new int[] {row, col};
    }
}