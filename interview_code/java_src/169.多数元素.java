class Solution {
    // 本题思路：
    // 遍历数组，维持map，数组元素和元素出现次数的映射，保持出现最大次数及相对应的元素
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_count = 0;
        int max_elem = nums[0];
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            int count = map.get(num);
            if (count > max_count) {
                max_count = count;
                max_elem = num;
            }
        }
        return max_elem;
    }
}