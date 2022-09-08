package main.java.org.code.top;


import main.java.org.code.top.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * describe:
 二叉树翻转

 示例：

 输入：

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 输出：

 4
 /   \
 7     2
 / \   / \
 9   6 3   1


 作者：LeetCode
 链接：https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode/

 * @author lixilong
 * @date 2019/12/01
 */
public class _lc_226_E_NvertTree {


  //  方法1：递归，本质就是反转每个节点的左右子树
  public TreeNode invertTree(TreeNode root) {
    if (root == null)  return null;

    //先处理下层翻转。
    TreeNode right = invertTree(root.right);
    TreeNode left = invertTree(root.left);

    //下层子树翻转未完成，反转当前层的子树即可得到最终结果
    root.left = right;
    root.right = left;

    return root;
  }


  // 迭代
  public TreeNode invertTree2(TreeNode root) {
    if (root == null) return null;

    Queue<TreeNode> queue = new LinkedList<TreeNode>(); //队列来存储所有左孩子和右孩子还没有被交换过的节点。
    queue.add(root);

    while (!queue.isEmpty()) { //队列空时,所有节点的孩子节点都被互换过了
      TreeNode current = queue.poll(); //临时变量，处理中一直在变，且遍历一次后无用，故而出队

      TreeNode temp = current.left; current.left = current.right; current.right = temp;

      if (current.left != null) queue.add(current.left);
      if (current.right != null) queue.add(current.right);
    }
    return root;
  }





}
