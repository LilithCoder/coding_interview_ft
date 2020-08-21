// "static void main" must be defined in a public class.
public class Main {
    public static char curr_char;
    public static int getCountOfClusters(int numOfRows, List<String> grid) {
        int result = 0;
        if (grid == null || grid.size() == 0) return result;
        int numOfCols = grid.get(0).length();
        char[][] grids = new char[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                grids[i][j] = grid.get(i).charAt(j);
            }
        }
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                if (grids[i][j] != '0') {
                    curr_char = grids[i][j];
                    dfs(grids, i, j, numOfRows, numOfCols);
                    result++;
                }
            }
        }
        return result;
    }
    
    public static void dfs(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0' || grid[i][j] != curr_char) return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j, row, col);
        dfs(grid, i + 1, j, row, col);
        dfs(grid, i, j - 1, row, col);
        dfs(grid, i, j + 1, row, col);
    }
    
    public static void main(String[] args) {
        int numOfRows = 3;
        List<String> grid = new ArrayList<>(List.of("aabba", "aabba", "aaacb"));
        // 期望输出：5
        System.out.println("输出：" + getCountOfClusters(numOfRows, grid));
    }
}