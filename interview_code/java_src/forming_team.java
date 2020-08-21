// "static void main" must be defined in a public class.
public class Main {
    // 题目描述：组队，队伍的人数有下限，每个组员的技能等级需要满足在一个范围内，算出有多少个组能满足这样的要求
    public static int result;
    public static int numOfTeam(int num, int[] skills, int minAssociates, int minLevel, int maxLevel) {
        // 存放符合技能等级要求的同事
        ArrayList<Integer> associates = new ArrayList<>();
        for (int skill: skills) {
            if (skill >= minLevel && skill <= maxLevel) associates.add(skill);
        }
        
        // 回溯算法，子集
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(associates, 0, track);
        return result;
    }
    
    public static void backtrack(ArrayList<Integer> associates, int start, LinkedList<Integer> track) {
        // 当team人数大于等于3，计入result
        if (track.size() >= 3) result++;
        for (int i = start; i < associates.size(); i++) {
            track.add(associates.get(i));
            backtrack(associates, i + 1, track);
            track.removeLast();
        }
    }
    
    public static void main(String[] args) {
        // 同事的数量
        int num = 6;
        // 同事的技能等级
        int[] skills = new int[] {12, 4, 6, 13, 5, 10};
        // 最少的组员数量要求
        int minAssociates = 3;
        // 技能等级的下限
        int minLevel = 4;
        // 技能等级的上限
        int maxLevel = 10;
        // 预计输出：5
        System.out.println("输出：" + numOfTeam(num, skills, minAssociates, minLevel, maxLevel));
    }
}