// "static void main" must be defined in a public class.
public class Main {
    public static int uniquePairs(int[] nums, int target){
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for(int num : nums){
            if(set.contains(target-num) && !seen.contains(num)){
                count++;
                seen.add(target-num);
                seen.add(num);
            }
            else if(!set.contains(num)){
                set.add(num);
            }

        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 45, 46, 46};
        int target = 47;
        System.out.println("输出：" + uniquePairs(nums, target));
    }
}