// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：对每一个query(也就是某个Point(x, y)）, 在所有符合与Point的x or y相等的candidate points中找到距离最短的一个；如果没有符合条件的点就“NONE”
    public static List<String> nearestCity(int numofCities, List<String> cities, List<Integer> xCoordinates,
                                       List<Integer> yCoordinates, int numQueries, List<String> queries){
        ArrayList<String> res = new ArrayList<>();
        for (String ch: queries) {
            Set<String> candidates = new HashSet<>();
            int index = cities.indexOf(ch);
            System.out.print(index + "," + ch + " - ");
            int[] coord = new int[]{xCoordinates.get(index), yCoordinates.get(index)};
            System.out.print(coord[0] + "," + coord[1] + " - ");
            for (int i = 0; i < numofCities; i++) {
                if (ch == cities.get(i)) continue;
                if (xCoordinates.get(i) == coord[0]) candidates.add(cities.get(i));
            }
            for (int i = 0; i < numofCities; i++) {
                if (ch == cities.get(i)) continue;
                if (yCoordinates.get(i) == coord[1]) candidates.add(cities.get(i));
            }
            System.out.println(candidates);
            PriorityQueue<String> pqueue = new PriorityQueue<>((a, b) -> {
                int index_a = cities.indexOf(a);
                int distance_a = Math.abs(xCoordinates.get(index_a) - coord[0]) + Math.abs(yCoordinates.get(index_a) - coord[1]);
                int index_b = cities.indexOf(b);
                int distance_b = Math.abs(xCoordinates.get(index_b) - coord[0]) + Math.abs(yCoordinates.get(index_b) - coord[1]);
                if (distance_a != distance_b) return distance_a - distance_b;
                return a.compareTo(b);
            });
            for (String str: candidates) {
                pqueue.add(str);
            }
            res.add(pqueue.peek() == null ? "NONE" : pqueue.peek());
        }
        return res;
    }
    
    public static void main(String[] args) {
        int numofCities = 5;
        List<String> cities = new ArrayList<>(List.of("c1", "c2", "c3", "c4", "c5"));
        List<Integer> xCoordinates = new ArrayList<>(List.of(3, 2, 1, 1, 1));
        List<Integer> yCoordinates = new ArrayList<>(List.of(3, 2, 3, 4, 1));
        int numQueries = 3;
        List<String> queries = new ArrayList<>(List.of("c1", "c2", "c3"));
        // 期望输出：[c3, NONE, c4]
        System.out.println("输出：" + nearestCity(numofCities, cities, xCoordinates,
                                       yCoordinates, numQueries, queries));
    }
}