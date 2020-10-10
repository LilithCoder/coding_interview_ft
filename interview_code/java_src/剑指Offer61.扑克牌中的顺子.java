class Solution {
    // 本题思路：
    // 这个数组中0可以当任何数用，所以当牌不连续的时候，它就可以替补一下，进而达到顺的要求。
    // 举个例子 0 0 1 2 4 5 6,这个数组中，0有两个，所以我们有俩万能替补，接着我们可以发现2-4之间不连续，缺个3，这样我们就可以把一个0放到哪里当三
    // 0 1 2 0 4 5 6,   0代替了3的位置，达到了连续的要求
    // 此 5 张牌是顺子的 充分条件 如下：
    // 除大小王外，所有牌 无重复 ；
    // 设此 5 张牌中最大的牌为 max ，最小的牌为 min （大小王除外），则需满足：max - min < 5
    // 遍历五张牌，遇到大小王（即 0 ）直接跳过。
    // 判别重复： 利用 Set 实现遍历判重， Set 的查找方法的时间复杂度为 O(1)
    // 获取最大 / 最小的牌： 借助辅助变量，遍历统计即可。
    public boolean isStraight(int[] nums) {
        HashSet<Integer> repeat = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) {
                return false;
            } else {
                repeat.add(num);
            }
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}