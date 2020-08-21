class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> square_list = generate_square_list(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j: square_list) {
                if (i < j) break;
                dp[i] = Math.min(dp[i], dp[i - j] + 1);
            }
        }
        return dp[n];
    }
    private ArrayList<Integer> generate_square_list(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            result.add(i * i);
        }
        return result;
    }
}