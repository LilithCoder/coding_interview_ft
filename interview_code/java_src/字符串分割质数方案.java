// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：将给定的字符串分割，每个子串都是质数，计算有多少个方案
    public static boolean check_prime(String str) {
        int num = Integer.valueOf(str);
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return num > 1 ? true : false;
    }
    
    public static int num_ways_split_primes_helper(String num, int i) {
        if (i == 0) return 1;
        int result = 0;
        // 从index末位开始，考虑多达6位的后缀，考虑是否为prime，如果这个后缀没有leading zero并且是质数，那就递归地调用剩余的string，当index为0时，考虑这个方案为一个有效的方案，result++
        for (int j = 1; j <= 6; j++) {
            if (i - j >= 0 && num.charAt(i - j) != '0' && check_prime(num.substring(i - j, i))) {
                result += num_ways_split_primes_helper(num, i - j);
            }
        }
        return result;
    }
    
    public static int num_ways_split_primes(String inputString) {
        return num_ways_split_primes_helper(inputString, inputString.length());
    }
    public static void main(String[] args) {
        String inputString = "11373";
        // 期望输出：6
        // [11,3,7,3] [113,7,3] [11,3,73] [11,37,3] [113,73] [11,373]
        System.out.println("输出：" + num_ways_split_primes(inputString));
    }
}