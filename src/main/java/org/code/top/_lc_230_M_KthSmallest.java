package main.java.org.code.top;


import main.java.org.code.top.util.TreeNode;

/**
 * describe:
 * 二叉搜索树 找第 K大 或 K小 的节点
 * @author lixilong
 * @date 2019/12/01
 */
public class _lc_230_M_KthSmallest {

  /**
  时间复杂度：依次遍历前 k 个节点，因此时间复杂度为 O(k)
  空间复杂度：生成器只需要 O(1) 的空间，如果不考虑递归栈所占用的空间，那么复杂度为 O(1)
  作者：hzhu212
  链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/zhong-xu-bian-li-sheng-cheng-qi-ti-qian-zhong-zhi-/
 */


//
//  深度优先搜索1
//  算法思想：递归求左右子树高度，较大者 +1。

  public int maxDepth(TreeNode root) {
    return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  //中序遍历一颗二叉搜索树，遍历序列是递增排序的，可以很容易的得到它的第k大的节点。
  private int i = 0;
  private int ret;
  public int kthSmallest(TreeNode root, int k) {
    inOrder(root,k);
    return ret;
  }

  private void inOrder(TreeNode root, int k) {
    if (root == null)   return ;

    inOrder(root.left, k);

    if (++i == k) {
      ret = root.val;
      return;
    }

    inOrder(root.right, k);
  }

//  作者：woodhearo
//  链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/yun-xing-hao-shi-ji-bai-100yong-hu-de-ti-jie-by-wo/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

  /**
   拓展
   二叉搜索树，求解第K大元素
   */

  private int mostI = 0;
  private int mostRet;
  public int kthMostlest(TreeNode root, int k) {
    inOrder(root,k);
    return ret;
  }

  private void inOrder2(TreeNode root, int k) {
    if (root == null)   return ;
    inOrder(root.right, k);

    if (++i == k) {
      ret = root.val;
      return;
    }

    inOrder(root.left, k);
  }
}
