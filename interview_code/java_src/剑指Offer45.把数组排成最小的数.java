class Solution {
    // 本题思路：
    // 此题求拼接起来的 “最小数字” ，本质上是一个排序问题。
    // 排序判断规则： 设 numsnums 任意两数字的字符串格式 xx 和 yy ，则
    // 若拼接字符串 x + y > y + x，则 x > y
    // 反之，若 x + y < y + x，则 x < y
    // 3(30) > (30)3 -> 30 > 3
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> {return (a + b).compareTo(b + a);});
        StringBuilder res = new StringBuilder();
        for (String str: strs) res.append(str);
        return res.toString();
    }
}