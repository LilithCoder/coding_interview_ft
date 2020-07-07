/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;
        for (int price: prices) {
            if (price < min_price) {
                min_price = price;
            } else {
                max_profit = Math.max(max_profit, price - min_price);
            }
        }
        return max_profit;
    }
}
// @lc code=end

