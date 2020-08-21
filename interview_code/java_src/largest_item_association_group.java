// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：给定一列item对，每个item对是一个relationship，输出最大的item group，如果group大小相同，则根据字典顺序输出，输出的组也根据字典序排序
    static class PairString {
		String first;
		String second;
		PairString(String first, String second){
			this.first = first;
			this.second = second;
        }
	}
    
    // 深度优先搜索来探索连通分量
    public static void dfs(Map<String, List<String>> graph, String v, Set<String> marked, List<String> temp) {
        marked.add(v);
        temp.add(v);
        for (String adj: graph.get(v)) {
            if (!marked.contains(adj)) {
                dfs(graph, adj, marked, temp);
            }
        }
    }
    
    // 以字典序来排序字符串列
    public static int lexico_compare(List<String> temp, List<String> result) {
        String str1 = String.join(",", temp);
        String str2 = String.join(",", result);
        return str1.compareTo(str2);
    }
    
    public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
        // 以adj-list存放图
        Map<String, List<String>> graph = new HashMap<>();
        for (PairString p: itemAssociation) {
            
            // 添加first item的相邻item
            List<String> temp_f = graph.getOrDefault(p.first, new ArrayList<>());
            temp_f.add(p.second);
            graph.put(p.first, temp_f);
            
            // 添加second item的相邻item
            List<String> temp_s = graph.getOrDefault(p.second, new ArrayList<>());
            temp_s.add(p.first);
            graph.put(p.second, temp_s);
        }
        
        // 存放最大的连通分量
        List<String> result = new ArrayList<>();
        // 存放当前追踪的连通分量
        List<String> temp = new ArrayList<>();
        // 存放被访问过的item
        Set<String> marked = new HashSet<>();
        
        for (String v: graph.keySet()) {
            if (!marked.contains(v)) {
                dfs(graph, v, marked, temp);
                Collections.sort(temp);
                if (temp.size() > result.size()) {
                    result = temp;
                } else if (temp.size() == result.size()) {
                    result = lexico_compare(temp, result) < 0 ? temp : result;
                }
                // 当前追踪的连通分量清空
                temp = new ArrayList<>();
            }
        }
        return result;
	}   
    
    public static void main(String[] args) {
        List<PairString> itemAssociation = new ArrayList<>();
        itemAssociation.add(new PairString("Item1", "Item2"));
        itemAssociation.add(new PairString("Item3", "Item4"));
        itemAssociation.add(new PairString("Item4", "Item5"));
        // 期望输出：[Item3, Item4, Item5]
        System.out.println("输出：" + largestItemAssociation(itemAssociation));
    }
}