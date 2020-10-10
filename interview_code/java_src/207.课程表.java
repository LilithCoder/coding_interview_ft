class Solution {
    // 本题思路：
    // 这题就是拓扑排序，先修课程有向地指向后续课程，组成图
    // 所以当图中不存在有向环的时候，说明图中存在拓扑排序，课程可以安排拓扑排序按序完成
    // 用bfs进行拓扑排序：
    // 拓扑排序中最前面的节点，该节点一定不会有任何入边，也就是它没有任何的先修课程要求。
    // 当我们将一个节点加入答案中后，我们就可以移除它的所有出边，代表着它的相邻节点少了一门先修课程的要求。
    // 如果某个相邻节点变成了「没有任何入边的节点」，那么就代表着这门课可以开始学习了。
    // 按照这样的流程，我们不断地将没有入边的节点加入答案，直到答案中包含所有的节点（得到了一种拓扑排序）或者不存在没有入边的节点（图中包含环）。
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // 入度indegree：第i门课有indegree[i]门的先修课程
        int[] indegree = new int[numCourses];
        
        // 组建graph，key为先修，value为后续课程list
        // 初始化入度
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge: prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        
        // 存放已经拓扑排序过的课程
        List<Integer> topo_sorted = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        // 将所有目前入度为0的先修课程加入队列，从这些先修课程开始bfs遍历
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topo_sorted.add(curr);
            for (int adj: graph.get(curr)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    queue.add(adj);
                }
            }
        }
        return topo_sorted.size() == numCourses;
    }
}