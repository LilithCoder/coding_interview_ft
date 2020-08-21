// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：有个旋转门，进或出。一个人出同时另一个人进，如果上一秒旋转门没被用，要出门的人先走，上一秒是出的，让出的人先走，上一秒是进的，让进的人先走，通过旋转门需要一秒的时间。计算出每个顾客通过旋转门的时刻
    public static int[] turnstile(int numCustomers, int[] arrTime, int[] direction) {
        int[] output = new int[numCustomers];
        int prev = 1;
        int i = 0, j = 1, k = 0;

        while (j < numCustomers) {
            if (arrTime[i] == arrTime[j]) {
                if (direction[i] == prev) { // i goes first
                    output[i] = k;
                    arrTime[j]++;
                    i = j;
                    j++;
                } else { // j goes first
                    output[j] = k;
                    arrTime[i]++;
                    j++;
                }

            } else {
                output[i] = k;
                prev = direction[i];
                i = j;
                j++;

            }
            k++;
        }
        output[i] = Math.max(k, arrTime[i]);
        return output;
    }
    
    // num_customers: 4
    // arr_time: [0, 0, 1, 5]
    // direction: [0, 1, 1, 0], 
    // output: time ith customer pass the turnstile
    public static void main(String[] args) {
        // 顾客人数
        int numCustomers = 4;
        // arrTime[i]是第i个顾客来到旋转门的时间点
        int[] arrTime = new int[]{0, 0, 1, 5};
        // exit: 1, enter: 0 第i个顾客的进或出
        int[] direction = new int[]{0, 1, 1, 0};
        // 预期输出：[2, 0, 1, 5]    每个顾客通过旋转门的时刻
        System.out.print("输出：");
        for (int i: turnstile(numCustomers, arrTime, direction)) {
            System.out.print(i + ",");
        }
    }
}