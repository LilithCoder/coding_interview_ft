// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：
    // 对于某一件商品，有几家供应商，分别的库存就是数组inventory，然后获利的计算就是加上一个商家库存剩余数量，计算最大获利
    public static long highest_profit(int num_suppliers, int[] inventory, long order) {
        long result = 0;
        
        // 构建最大堆
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> {return b - a;});
        for (int i: inventory) {
            max_heap.add(i);
        }
        while (max_heap.size() > 0 && order > 0) {
            int profit = max_heap.poll();
            result += profit;
            max_heap.add(profit - 1);
            order--;
        }
        return result;
    }
    
    public static void main(String[] args) {
        // 供应商的数量
        // int num_suppliers = 2;
        int num_suppliers = 5;
        // 供应商库存的商品数量
        // int[] inventory = new int[]{3, 5};
        int[] inventory = new int[]{2, 8, 4, 10, 6};
        // 被下单的商品的数量
        // long order = 6;
        long order = 20;
        // 输出：某个特定商品能够得到的最大利润
        // 期望输出：19
        // 期望输出：110
        System.out.println(highest_profit(num_suppliers, inventory, order));
    }
}