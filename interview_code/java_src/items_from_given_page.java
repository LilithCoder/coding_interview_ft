// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：根据参数来返回商品名字的列表，商品用分页来显示，商品根据名字，相关性，价格来排序，返回指定页数的商品名字list
    static class PairInt {
        int relevance;
        int price;
        PairInt(int relevance, int price) {
            this.relevance = relevance;
            this.price = price;
        }
    }
    
    public static List<String> fetchItemsToDisplay(int numOfItems, HashMap<String, PairInt> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        List<List<String>> list_of_items = new ArrayList<>();
        // 所有商品加入优先队列，根据参数排序
        PriorityQueue<String> pqueue = new PriorityQueue<>((a, b) -> {
            if (sortParameter == 0) {
                // 根据名字排序
                if (sortOrder == 0) {
                    // 递增排序
                    return a.compareTo(b);
                } else {
                    // 递减排序
                    return b.compareTo(a);
                }
            } else if (sortParameter == 1) {
                // 根据相关性排序
                if (sortOrder == 0) {
                    // 递增排序
                    return items.get(a).relevance - items.get(b).relevance;
                } else {
                    // 递减排序
                    return items.get(b).relevance - items.get(a).relevance;
                }
            } else {
                // 根据价格排序
                if (sortOrder == 0) {
                    // 递增排序
                    return items.get(a).price - items.get(b).price;
                } else {
                    // 递减排序
                    return items.get(b).price - items.get(a).price;
                }
            }
        });
        pqueue.addAll(items.keySet());
        
        int curr_page = 0;
        int curr_item_num = 0;
        list_of_items.add(new ArrayList<>());
        
        while (!pqueue.isEmpty()) {
            String temp = pqueue.poll();
            if (curr_item_num == itemsPerPage) {
                list_of_items.add(new ArrayList<>());
                curr_page++;
                curr_item_num = 0;
            }
            list_of_items.get(curr_page).add(temp);
            curr_item_num++;
        }
        if (pageNumber >= list_of_items.size()) return new ArrayList<>();
        
        return list_of_items.get(pageNumber);
    }
    
    public static void main(String[] args) {
        // 商品的数量
        int numOfItems = 3;
        // key为商品名字，value为integer值的对（相关性和价格）
        HashMap<String, PairInt> items = new HashMap<>();
        items.put("item1", new PairInt(10, 15));
        items.put("item2", new PairInt(3, 4));
        items.put("item3", new PairInt(17, 8));
        // 排序参考用的参数，0为名字，1为相关性，2为价格
        int sortParameter = 1;
        // 0为递增，1为递减
        int sortOrder = 0;
        // 每页显示的商品数量
        int itemsPerPage = 2;
        // 显示商品的页数
        int pageNumber = 1;
        // 期望输出：[item3]
        System.out.println("输出：" + fetchItemsToDisplay(numOfItems, items, sortParameter, sortOrder, itemsPerPage, pageNumber));
    }
}