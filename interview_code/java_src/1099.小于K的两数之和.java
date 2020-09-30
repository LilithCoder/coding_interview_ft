class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) return -1;
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int res = Integer.MIN_VALUE;
        while (left < right) {
            if (A[left] + A[right] >= K) {
                right--;
            } else {
                res = Math.max(res, A[left] + A[right]);
                left++;
            }
        }
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}