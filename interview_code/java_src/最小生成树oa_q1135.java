// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：data center，最小生成树
    static class Pair{
        char from, to;
        int cost;
        Pair(char from, char to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    // 合并集
    static class UnionFind {
        // 记录连通分量的个数
        private int count;
        // 根结点
        private Map<Character, Character> parent;
        
        UnionFind(int N, ArrayList<Pair> connections) {
            this.count = N;
            parent = new HashMap<>();
            for (Pair p: connections) {
                parent.put(p.from, p.from);
                parent.put(p.to, p.to);
            }
        }
        
        // 合并两个结点，使其成为一个连通分量
        public void union(char p, char q) {
            char root_p = find(p);
            char root_q = find(q);
            if (root_p == root_q) return;
            
            // 将两棵树合并为一棵, 让其中一个结点的根结点接到另一个结点的根结点上
            parent.put(root_p, root_q);
            count--;
        }
        
        // 返回某个结点x的根结点
        public char find(char x) {
            while (parent.get(x) != x) {
                x = parent.get(x);
            }
            return x;
        }
        
        // 返回结点p和结点q是否连通
        public boolean connected(char p, char q) {
            char root_p = find(p);
            char root_q = find(q);
            return root_p == root_q;
        }
        
        // 返回当前的连通分量的个数
        public int count() {
            return count;
        }
    }
    
    // Kruskal算法
    public static ArrayList<Pair> minimumCost(int N, ArrayList<Pair> connections) {
        // 将所有的边按照权重从小到大排序
        Collections.sort(connections, (a, b) -> {return a.cost - b.cost;});
        
        UnionFind uf = new UnionFind(N, connections);
        ArrayList<Pair> result = new ArrayList<>();
        for (Pair edge: connections) {
            // if edge.from 和 edge.to 不在同一连通分量
            if (!uf.connected(edge.from, edge.to)) {
                uf.union(edge.from, edge.to);
                result.add(new Pair(edge.from, edge.to, edge.cost));
                // 如果连通分量个数为1，则跳出循环
                if (uf.count() == 1) break;
            }
        }
        return uf.count() == 1 ? result : null;
    }
    
    public static void main(String[] args) {
        int N = 5;
        ArrayList<Pair> connections = new ArrayList<>();
        connections.add(new Pair('A', 'B', 1));
        connections.add(new Pair('B', 'C', 4));
        connections.add(new Pair('B', 'D', 6));
        connections.add(new Pair('D', 'E', 5));
        connections.add(new Pair('C', 'E', 1));
        System.out.println("输出：");
        for (Pair p: minimumCost(N, connections)) {
            System.out.println("[" + p.from + "," + p.to + "," + p.cost + "]");
        }
    }
}


//========================================================================================================================

class Solution {
    // 题目描述：data center，最小生成树
    // 合并集
    class UnionFind {
        // 记录连通分量的个数
        private int count;
        // 根结点
        private int[] parent;
        
        UnionFind(int N) {
            this.count = N;
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }
        }
        
        // 合并两个结点，使其成为一个连通分量
        public void union(int p, int q) {
            int root_p = find(p);
            int root_q = find(q);
            if (root_p == root_q) return;
            
            // 将两棵树合并为一棵, 让其中一个结点的根结点接到另一个结点的根结点上
            parent[root_p] = root_q;
            count--;
        }
        
        // 返回某个结点x的根结点
        public int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }
        
        // 返回结点p和结点q是否连通
        public boolean connected(int p, int q) {
            int root_p = find(p);
            int root_q = find(q);
            return root_p == root_q;
        }
        
        // 返回当前的连通分量的个数
        public int count() {
            return count;
        }
    }
    
    // Kruskal算法
    public int minimumCost(int N, int[][] connections) {
        // 将所有的边按照权重从小到大排序
        Arrays.sort(connections, new Comparator<int[]>() {
            public int compare(int[] edge_a, int[] edge_b) {
                return edge_a[2] - edge_b[2];
            }
        });
        
        UnionFind uf = new UnionFind(N);
        int result = 0;
        for (int[] edge: connections) {
            // if edge[0] 和 edge[1] 不在同一连通分量
            if (!uf.connected(edge[0], edge[1])) {
                result += edge[2];
                uf.union(edge[0], edge[1]);
                // 如果连通分量个数为1，则跳出循环
                if (uf.count() == 1) break;
            }
        }
        return uf.count() == 1 ? result : -1;
    }
}
