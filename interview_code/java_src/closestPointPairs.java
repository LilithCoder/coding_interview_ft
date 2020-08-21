// "static void main" must be defined in a public class.
// 自己的解法：
class Solution {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // 返回两个点的平方距离和
    public int square_distance (Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
    
    // 找到strip数组中最小的平房距离和
    public int strip_cloest(Point[] strip, int num_robots, double d) {
        int min = Integer.MAX_VALUE;
        
        // 根据y轴从小到大排序
        Arrays.sort(strip, new Comparator<Point>() {
            public int compare(Point point_a, Point point_b) {
                return point_a.y - point_b.y;
            }
        });
        
        // 尝试每个点对直到每个点对的y轴差距小于d
        for (int i = 0; i < num_robots; i++) {
            for (int j = i + 1; j < num_robots && (strip[j].y - strip[i].y < d); j++) {
                min = Math.min(min, square_distance(strip[i], strip[j]));
            }
        }
        return min;
    }
    
    public int brute_force(Point[] points, int num_robots) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < num_robots; i++) {
            for (int j = i + 1; j < num_robots; j++) {
                result = Math.min(result, square_distance(points[i], points[j]));
            }
        }
        return result;
    }
    
    public int recursion_helper(Point[] points, int num_robots) {
        // 如果只有两个或者三个点，直接暴力解
        if (num_robots <= 3) return brute_force(points, num_robots);
        
        // 将所有的点分为两个部分
        int mid = num_robots / 2;
        Point mid_point = points[mid];
        
        // 递归地找到左右两个部分各自最小的平方距离和
        int min_dist_left = recursion_helper(Arrays.copyOfRange(points, 0, mid), mid);
        int min_dist_right = recursion_helper(Arrays.copyOfRange(points, mid, num_robots), num_robots - mid);
        
        // 取左右两个最小平方距离和中较小的那个
        int d = Math.min(min_dist_left, min_dist_right);
        
        // 建立一个数组strip包含了距离中隔线小于d的点
        Point[] strip = new Point[num_robots];
        int j = 0;
        for (int i = 0; i < num_robots; i++) {
            if (Math.abs(points[i].x - mid_point.x) < Math.sqrt(d)) {
                strip[j] = points[i];
                j++;
            }
        }
        
        // 找到strip数组中最小的平方距离和
        int d0 = strip_cloest(points, j, Math.sqrt(d));
        
        return Math.min(d, d0);
    }
    
    public int shortest_robot_distance(int num_robots, int[] position_x, int[] position_y) {        
        if (num_robots == 0 || num_robots == 1) return 0;
        
        // 构建点的数组
        Point[] points = new Point[num_robots];
        for (int i = 0; i < num_robots; i++) {
            points[i] = new Point(position_x[i], position_y[i]);
        }
        
        // 根据点的x坐标排序
        Arrays.sort(points, new Comparator<Point>() {
            public int compare(Point point_a, Point point_b) {
                return point_a.x - point_b.x;
            }
        });
        
        // 调用递归函数找到最小平方距离的点对，分治策略
        return recursion_helper(points, num_robots);
    }
}
public class Main {
    // num_robots = 3
    // position_x = [0, 1, 2]
    // position_y = [0, 1, 4]
    public static void main(String[] args) {
        int num_robots = 6;
        int[] position_x = new int[]{0, 1, 2, 19, 23231, 2323};
        int[] position_y = new int[]{0, 1, 4, 202, 2323, 454};
        Solution s = new Solution();
        System.out.println(s.shortest_robot_distance(num_robots, position_x, position_y));
    }
}

