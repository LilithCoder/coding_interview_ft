class TwoSum {
    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i: map.keySet()) {
            int complement = value - i;
            if (i == complement && map.get(i) >= 2) return true;
            if (i != complement && map.containsKey(complement)) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */