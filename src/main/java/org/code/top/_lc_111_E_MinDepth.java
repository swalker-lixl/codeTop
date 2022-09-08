package main.java.org.code.top;


import main.java.org.code.top.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * describe:
 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回它的最小深度  2.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @author lixilong
 * @date 2019/01/25
 */
public class _lc_111_E_MinDepth {


    public int minDepth(TreeNode root) {
      if(root == null) return 0;
      int m1 = minDepth(root.left);
      int m2 = minDepth(root.right);

      //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
      //2.如果都不为空，返回较小深度+1
      return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
    }


    //方法2：迭代方式 2ms
    public int minDepth1(TreeNode root) {
      if (root == null) return 0;
      Queue<TreeNode> q = new LinkedList<TreeNode>();

      q.add(root);

      int minH = Integer.MAX_VALUE, h = 1;

      while (!q.isEmpty()) {
        Queue<TreeNode> tmp = new LinkedList<TreeNode>();
        while(!q.isEmpty()) {
          TreeNode cur = q.poll();
          if (cur.left == null && cur.right == null)
            minH = Math.min(h, minH);
          if (cur.left != null) tmp.add(cur.left);
          if (cur.right != null) tmp.add(cur.right);
        }
        q = tmp;
        h++;
      }
      return minH;
    }

  }
