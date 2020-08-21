class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int min_cap = max_weight(weights);
        int max_cap = sum_weight(weights);
        while (min_cap < max_cap) {
            int mid_cap = (min_cap + max_cap) / 2;
            if (can_finish(mid_cap, weights, D)) {
                max_cap = mid_cap;
            } else {
                min_cap = mid_cap + 1;
            }
        }
        return min_cap;
    }
    private int max_weight(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int i: weights) {
            max = Math.max(max, i);
        }
        return max;
    }
    private int sum_weight(int[] weights) {
        int sum = 0;
        for (int i: weights) {
            sum += i;
        }
        return sum;
    }
    private boolean can_finish(int cap, int[] weights, int D) {
        int day = 0;
        int left_cap = cap;
        for (int weight: weights) {
            if (left_cap < weight) {
                left_cap = cap;
                day++;
            }
            left_cap -= weight;
        }
        return day < D;
    }
}