// "static void main" must be defined in a public class.
// 题目描述：寻找平均数最大的子树
// 自己的解法：
public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    double max_avg = 0;
    TreeNode result = null;
    public TreeNode maximumAverageSubtree(TreeNode root) {
        if (root == null) return root;
        helper(root);
        return result;
    }
    // 后序遍历：
    private int[] helper(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) return arr;
        
        // 每次遍历返回当前子树的元素和和节点个数
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        // 使用数组arr储存，arr[0]为元素和，arr[1]为节点个数
        arr[0] = left[0] + right[0] + root.val;
        arr[1] = left[1] + right[1] + 1;
        
        // 更新包括当前根节点在内的平均值
        double temp_avg = (double) (arr[0]) / arr[1];
        if (temp_avg >= max_avg) {
            max_avg = temp_avg;
            result = root;
        }
        return arr;
    }
}

//============================================================================================================================================

import java.util.*;

class Pair{
	int totalNodes, totalSum;
	Pair(int total, int sum){
		this.totalNodes = total;
		this.totalSum = sum;
	}
}

class MaxTenureFinder
{
	public static Pair findHighestTenure(HashMap<Integer, ArrayList<Integer>> hmap, int V){
		if(hmap.get(V).size() == 0){
			return new Pair(1, V);
		}
		else{
			int totalNodesCount = 1;
			int totalSum = V;
			for(int i=0;i<hmap.get(V).size();i++){
				Pair temp = findHighestTenure(hmap, hmap.get(V).get(i));
				totalNodesCount += temp.totalNodes;
				totalSum += temp.totalSum;
			}
			
			if(totalSum * maxSum.totalNodes >= maxSum.totalSum * totalNodesCount){ // logic to avoid precision error
				maxSum.totalNodes = totalNodesCount;
				maxSum.totalSum = totalSum;
				maxTenureNode = V;
			}
			
			return new Pair(totalNodesCount, totalSum);
		}
	}
	
	public static int maxTenureNode;
	public static Pair maxSum;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<> ();
		
		for(int i=0;i<n;i++){
			int parent = sc.nextInt();
			int child = sc.nextInt();
			if(hmap.containsKey(parent)){
				hmap.get(parent).add(child);
			}
			else{
				ArrayList<Integer> temp = new ArrayList<> ();
				temp.add(child);
				hmap.put(parent, temp);
			}
			if(!hmap.containsKey(child)){
				hmap.put(child, new ArrayList<> ());
			}
		}
		int parentNode = sc.nextInt();
		maxSum = new Pair(0, 0);
		maxTenureNode = -1;
		findHighestTenure(hmap, parentNode);
		System.out.println(maxTenureNode);
	}
}