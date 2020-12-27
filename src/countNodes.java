/**
 * @title 222. 完全二叉树的节点个数
 * <p>
 * 完全二叉树：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 对于任意二叉树，都可以广度（BFS）和深度（DFS）优先搜素计算节点个数，时间复杂度为O(n)。
 */


public class countNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //采用二分查找和位运算
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        //遍历二叉树的层数
        while (node.left != null) {
            level++;
            node = node.left;
        }
        //位运算 左移<< :若左移的时舍弃的高位不包含1，相当于该数乘以2.
        //计算该完全二叉树最少和最多的节点个数2^level~2^(level+1)-1
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        //循环二分查找
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            //判断mid个节点数是否存在
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        //计算level-1的最小的节点数
        int bits = 1 << (level - 1);
        TreeNode node = root;
        //循环遍历的到k的路径
        while (node != null && bits > 0) {
            //如果bits&k == 0，说明k存在于二叉树中
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

}
