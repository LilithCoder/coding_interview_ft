class Solution {
    // 本题思路：
    // 后序遍历定义： [ 左子树 | 右子树 | 根节点 ] ，即遍历顺序为 “左、右、根” 。
    // 二叉搜索树定义： 左子树中所有节点的值 < 根节点的值；右子树中所有节点的值 > 根节点的值；其左、右子树也分别为二叉搜索树。
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }
    public boolean helper(int[] postorder, int start, int end) {
        // 当递归到子树只有一个结点或者该子树不存在，直接返回true
        if (start >= end) return true;
        int index = start;
        int root = postorder[end];
        // 遍历寻找左子树的边界，左子树所有结点比root小
        while (postorder[index] < root) index++;
        int mid = index;
        // 遍历右子树，如果有<=root的结点出现，直接返回false
        for (int i = index; i < end; i++) {
            if (postorder[i] <= root) return false;
        }
        return helper(postorder, start, mid - 1) && helper(postorder, mid, end - 1);
    }
}