package main.java.org.code.top;


import main.java.org.code.top.util.TreeNode;

/**
 * describe:
 返回与给定的前序和后序遍历匹配的任何二叉树。

  pre 和 post 遍历中的值是不同的正整数。

  

 示例：

 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 输出：[1,2,3,4,5,6,7]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 * @author lixilong
 * @date 2019/12/29
 */
public class _lc_889_M_ConstructFromPrePost2 {

  int preIndex = 0, posIndex = 0;
  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    TreeNode root = new TreeNode(pre[preIndex++]);
    if (root.val != post[posIndex])
      root.left = constructFromPrePost(pre, post);
    if (root.val != post[posIndex])
      root.right = constructFromPrePost(pre, post);
    posIndex++;
    return root;
  }
/*
  作者：caipengbo
  链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solution/jian-dan-qiao-miao-yi-dong-de-javadi-gui-jie-fa-by/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

}
