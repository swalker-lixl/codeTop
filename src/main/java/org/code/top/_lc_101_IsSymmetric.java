package main.java.org.code.top;


import main.java.org.code.top.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * describe:


 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
 说明:

 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

 作者：LeetCode
 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 * @date 2019/12/01
 */
public class _lc_101_IsSymmetric {

  /***方法1：递归
   如果同时满足下面的条件，两个树互为镜像：

   它们的两个根结点具有相同的值。
   左节点的左子树和有节点的右子树相等，左节点的右子树和有节点的左子树相等。
   右节点的每个树的右子树都与另一个树的左子树镜像对称。
   * */
  public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
  }

/**
 方法二：迭代 比较两个左子树【森林】
 队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。
 最初，队列中包含的是 root 以及 root。
 该算法的工作原理类似于 BFS，但存在一些关键差异。每次提取两个结点并比较它们的值。
 然后，将两个结点的左右子结点按相反的顺序插入队列中。
 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。

 * */
  public boolean isSymmetric2(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root); q.add(root); //顺序加入两边根节点表示左右子树[森林]

    while (!q.isEmpty()) {
      TreeNode t1 = q.poll();
      TreeNode t2 = q.poll();

      if (t1 == null && t2 == null) continue;
      if (t1 == null || t2 == null) return false;
      if (t1.val != t2.val) return false;

      q.add(t1.left); q.add(t2.right); //顺序加入左子树左节点和右子树右节点
      q.add(t1.right); q.add(t2.left); //顺序加入左子树右节点和右子树左节点
    }
    return true;
  }


}
