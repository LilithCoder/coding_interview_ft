class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int square_sum = left * left + right * right;
            if (square_sum == c) return true;
            if (square_sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}