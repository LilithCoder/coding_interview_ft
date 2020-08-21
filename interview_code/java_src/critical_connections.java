// "static void main" must be defined in a public class.
public class Main {
    // 题目描述 lc#1192：数据中心有n台服务器，分别按从1到n的方式进行了编号。它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群。「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。返回该集群内的所有 「关键连接」。
    static class PairInt {
        int first;
        int second;
        PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public static void DFS(Map<Integer, HashSet<Integer>> adj, int u){
        visited.put(u, true);
        if(adj.get(u).size()!=0){
            for(int v : adj.get(u)){
                if(visited.getOrDefault(v, false)== false){
                    DFS(adj,v);
                }
            }
        }
    }
    
    static List<PairInt> list;
    static Map<Integer, Boolean> visited;
    // 一条边只有当不在一个环里时，这条边才是关键边。在所有节点上执行dfs之后，将丢弃周期中的所有边沿。 因此，其余边缘是关键连接。
    public static List<PairInt> criticalConnections(int numOfServers, int numOfConnections, List<PairInt> connections) {
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for(PairInt connection : connections){
            int u = connection.first;
            int v = connection.second;
            if(adj.get(u) == null){
                adj.put(u,new HashSet<Integer>());
            }
            adj.get(u).add(v);
            if(adj.get(v) == null){
                adj.put(v,new HashSet<Integer>());
            }
            adj.get(v).add(u);
        }
       
        list = new ArrayList<>();
        for(int i =0;i<numOfConnections;i++){
            visited = new HashMap<>();
            PairInt p = connections.get(i);
            int x = p.first;
            int y = p.second;
            adj.get(x).remove(y);
            adj.get(y).remove(x);
            DFS(adj,1);
            if(visited.size()!=numOfServers){
                    if(p.first > p.second)
                        list.add(new PairInt(p.second,p.first));
                    else
                        list.add(p);
            }
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        return list;
    }
    
    public static void main(String[] args) {
        int numOfServers = 5;
        int numOfConnections = 5;
        List<PairInt> connections = new ArrayList<>(List.of(new PairInt(1, 2), new PairInt(1, 3), new PairInt(3, 4), new PairInt(1, 4), new PairInt(4, 5)));
        System.out.println("输出：");
        for (PairInt p: criticalConnections(numOfServers, numOfConnections, connections)) {
            System.out.println("[" + p.first + "," + p.second + "]");
        }
    }
}