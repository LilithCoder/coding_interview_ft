public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            n &= (n - 1);
            sum++;
        }
        return sum;
    }
}