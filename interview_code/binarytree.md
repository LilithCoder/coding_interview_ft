# 二叉树

二叉树的套路:
```
void traverse(TreeNode root) {
    // 前序遍历
    traverse(root.left)
    // 中序遍历
    traverse(root.right)
    // 后序遍历
}

TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
}
```

[Leetcode Q236](java_src/236.二叉树的最近公共祖先.java) 二叉树的最近公共祖先 [大佬分析](https://mp.weixin.qq.com/s/9RKzBcr3I592spAsuMH45g)
```
二叉树的递归
```

[Leetcode Q222](java_src/222.完全二叉树的节点个数.java) 完全二叉树的节点个数 [大佬分析](https://mp.weixin.qq.com/s/xW2fbE3v4JhMSKfxoxIHBg)
```
如果是一个普通二叉树，显然只要向下面这样遍历一边即可，时间复杂度 O(N)：

public int countNodes(TreeNode root) {
    if (root == null) return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
}
那如果是一棵满二叉树，节点总数就和树的高度呈指数关系，时间复杂度 O(logN)：

public int countNodes(TreeNode root) {
    int h = 0;
    // 计算树的高度
    while (root != null) {
        root = root.left;
        h++;
    }
    // 节点总数就是 2^h - 1
    return (int)Math.pow(2, h) - 1;
}
完全二叉树比普通二叉树特殊，但又没有满二叉树那么特殊，计算它的节点总数，可以说是普通二叉树和完全二叉树的结合版，先看代码：
public int countNodes(TreeNode root) {
    TreeNode l = root, r = root;
    // 记录左、右子树的高度
    int hl = 0, hr = 0;
    while (l != null) {
        l = l.left;
        hl++;
    }
    while (r != null) {
        r = r.right;
        hr++;
    }
    // 如果左右子树的高度相同，则是一棵满二叉树
    if (hl == hr) {
        return (int)Math.pow(2, hl) - 1;
    }
    // 如果左右高度不同，则按照普通二叉树的逻辑计算
    return 1 + countNodes(root.left) + countNodes(root.right);
}
一棵完全二叉树的两棵子树，至少有一棵是满二叉树：
```
