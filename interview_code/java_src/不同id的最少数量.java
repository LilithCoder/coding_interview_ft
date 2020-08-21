// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：给定一列产品id，去除m个id，以至于剩下最少数量的不同的商品，返回不同id的最少数量
    public static int minimum_distinct_ids(int num, ArrayList<Integer> ids, int rem) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int id: ids) {
            map.put(id, map.getOrDefault(id, 0) + 1);
        }
        // 根据id的出现次数排序
        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a, b) -> {return a[1] - b[1];});
        for (int key: ids) {
            min_heap.add(new int[] {key, map.get(key)});
        }
        for (int i = 0; i < rem; i++) {
            min_heap.remove();
        }
        Set<Integer> result = new HashSet<>();
        while (!min_heap.isEmpty()) {
            result.add(min_heap.poll()[0]);
        }
        return result.size();
    }
    public static void main(String[] args) {
        int num = 6;
        ArrayList<Integer> ids = new ArrayList<>(List.of(1, 1, 1, 2, 3, 2));
        int rem = 2;
        // 期望输出：2
        System.out.println("输出：" + minimum_distinct_ids(num, ids, rem));
    }
}