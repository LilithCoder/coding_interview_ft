class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int min_speed = 1;
        int max_speed = max_speed_func(piles);
        while (min_speed < max_speed) {
            int mid_speed = (min_speed + max_speed) / 2;
            if (can_eat(mid_speed, piles, H)) {
                max_speed = mid_speed;
            } else {
                min_speed = mid_speed + 1;
            }
        }
        return min_speed;
    }
    private int max_speed_func(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i: piles) {
            max = Math.max(max, i);
        }
        return max;
    }
    private boolean can_eat(int speed, int[] piles, int H) {
        int hours = 0;
        for (int i: piles) {
            hours += (i / speed) + (i % speed > 0 ? 1 : 0); 
        }
        return hours <= H;
    }
}