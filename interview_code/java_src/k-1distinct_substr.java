// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：给定一个字符串，一个数字k，找到所有长度为k的子串，每个子串其中有k-1个不同的字符
    public static boolean check_func(String str, int n) {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            s.add(str.charAt(i));
        }
        return s.size() == n - 1 ? true : false;
    }
    
    public static List<String> subStringsLessKDist(String inputstring, int k) {
        List<String> result = new ArrayList<>();
        if (inputstring == null || inputstring.length() == 0) return result;
        int low = 0;
        int high = k - 1;
        while (high < inputstring.length()) {
            String str = inputstring.substring(low, high + 1);
            if (check_func(str, k)) {
                result.add(str);
            }
            low++;
            high++;
        }
        return result;
	}
    
    public static void main(String[] args) {
        String inputstring = "awaglk";
        int k = 4;
        // 期望输出：[awag]
        System.out.println("输出：" + subStringsLessKDist(inputstring, k));
    }
}