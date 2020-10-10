class Solution {
    // 本题思路：
    // 使用位运算。对于这道题，可使用异或运算。异或运算有以下三个性质。
    // 任何数和 0 做异或运算，结果仍然是原来的数
    // 任何数和其自身做异或运算，结果是 0
    // 异或运算满足交换律和结合律
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result = result ^ num;
        }
        return result;
    }
}