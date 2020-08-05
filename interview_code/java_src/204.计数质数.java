/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
// class Solution {
//     public int countPrimes(int n) {
//         boolean[] is_prime = new boolean[n];
//         Arrays.fill(is_prime, true);
//         for (int i = 2; i * i < n; i++) {
//             if (is_prime[i]) {
//                 for (int j = i * i; j < n; j += i) {
//                     is_prime[j] = false;
//                 }
//             }
//         }
//         int count = 0;
//         for (int i = 2; i < n; i++) {
//             if (is_prime[i]) count++;
//         }
//         return count;
//     }
// }

class Solution {
    public int countPrimes(int n) {
        boolean[] is_prime = new boolean[n];
        Arrays.fill(is_prime, true);
        for (int i = 2; i < n; i++) {
            if (is_prime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    is_prime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (is_prime[i]) count++;
        }
        return count;
    }
}
// @lc code=end

