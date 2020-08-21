// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：
    // 用一辆货车运送商品，所有商品在大小相同的箱子里，每个商品被装在每个箱子的几个单元里，计算出货车承载最大的单元数量
    public static long getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        for (int i = 0; i < num; i++) {
            // 第i个商品有n个箱子
            int n = boxes.get(i);
            // 加入n个箱子进入最小堆
            for (int j = 0; j < n; j++) {
                min_heap.add(unitsPerBox.get(i));
            }
        }
        
        // 排出最小的元素直到最小堆只有k个最大的箱子
        while (min_heap.size() != truckSize) {
            min_heap.poll();
        }
        
        // 计算这k个最大的箱子的单元和
        int result = 0;
        while (!min_heap.isEmpty()) {
            result += min_heap.poll();
        }
        return result;
    }
    
    public static void main(String[] args) {
        // 商品的数量
        int num = 3;
        // 代表对于产品可提供的箱子数量的数列
        ArrayList<Integer> boxes = new ArrayList<>(List.of(1, 2, 3));
        // 每个箱子的单元大小
        int unitSize = 3;
        // 每个箱子的单元数量
        ArrayList<Integer> unitsPerBox = new ArrayList<>(List.of(3, 2, 1));
        // 货车能放置的箱子数量
        long truckSize = 3;
        // 商品1 [3]
        // 商品2 [2][2]
        // 商品3 [1][1][1]
        // 预计输出：7 (3+2+2=7)
        System.out.println("输出：" + getMaxUnit(num, boxes, unitSize, unitsPerBox, truckSize));
    }
}