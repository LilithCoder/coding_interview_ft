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

[Leetcode Q94](java_src/94.二叉树的中序遍历.java) 94.二叉树的中序遍历
```
二叉树的中序遍历, 迭代方式
```

[Leetcode Q145](java_src/145.二叉树的后序遍历.java) 145.二叉树的后序遍历
```
二叉树的后序遍历, 迭代方式
```

[Leetcode Q144](java_src/144.二叉树的前序遍历.java) 144.二叉树的前序遍历
```
二叉树的前序遍历, 迭代方式
```

[Leetcode Q102](java_src/102.二叉树的层序遍历.java) 102.二叉树的层序遍历
```
二叉树的层序遍历 bfs
```

[Leetcode Q103](java_src/103.二叉树的锯齿形层次遍历.java) 103.二叉树的锯齿形层次遍历
```
二叉树的锯齿形层次遍历 bfs
```

[Leetcode Q987](java_src/987.二叉树的垂序遍历.java) 987.二叉树的垂序遍历
```
dfs+排序
```

[Leetcode Q429](java_src/429.N叉树的层序遍历.java) 429.N叉树的层序遍历
```
bfs
```

[Leetcode Q589](java_src/589.N叉树的前序遍历.java) 589.N叉树的前序遍历
```
N叉树的前序遍历
```

[Leetcode Q590](java_src/590.N叉树的后序遍历.java) 590.N叉树的后序遍历
```
N叉树的后序遍历
```

[Leetcode Q105](java_src/105.从前序与中序遍历序列构造二叉树.java) 105.从前序与中序遍历序列构造二叉树
```
只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，对上述形式中的所有左右括号进行定位。

这样以来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍历结果，我们就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置。
```

[Leetcode Q655](java_src/655.输出二叉树.java) 655.输出二叉树
```
二叉树的递归
```

[Leetcode Q104](java_src/104.二叉树的最大深度.java) 104.二叉树的最大深度
```
二叉树的递归
```

[Leetcode Q101](java_src/101.对称二叉树.java) 101.对称二叉树
```
二叉树的递归
```

[Leetcode Q257](java_src/257.二叉树的所有路径.java) 257.二叉树的所有路径
```
回溯算法
```

[Leetcode Q112](java_src/112.路径总和.java) 112.路径总和
```
二叉树的递归
```

[Leetcode Q113](java_src/113.路径总和II.java) 113.路径总和II
```
回溯算法
```

[Leetcode Q437](java_src/437.路径总和III.java) 437.路径总和III
```
双重递归、回溯算法
```

[Leetcode Q124](java_src/124.二叉树中的最大路径和.java) 124.二叉树中的最大路径和
```
    二叉树递归
    // 本题思路：
    // 每一个经过当前递归root结点的最大路径和是max(左子树的最大贡献值，右子树的最大贡献值)+当前root的值
    // 这个路径能路过的顶峰就是root
    // 最大贡献值是当前子树的root结点开始向下最大路径和
    // 每次递归返回的是最大贡献值，然后维持一个变量来记录经过当前递归root结点的最大路径和
```
230. 二叉搜索树中第K小的元素
236. 二叉树的最近公共祖先
235. 二叉搜索树的最近公共祖先
297. 二叉树的序列化与反序列化
428. 序列化和反序列化 N 叉树
543. 二叉树的直径
199. 二叉树的右视图
100. 相同的树
700. 二叉搜索树中的搜索
98. 验证二叉搜索树
701. 二叉搜索树中的插入操作
450. 删除二叉搜索树中的节点
108. 将有序数组转换为二叉搜索树