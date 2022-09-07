package main.java.org.code.top.Template;


import main.java.org.code.top.util.TreeNode;

import java.util.LinkedList;

/**
 * describe:

 树 pdf8

 def preorder(self, root):
    if root:
    self.traverse_path.append(root.val)
    self.preorder(root.left)
    self.preorder(root.right)

 def inorder(self, root):
    if root:
    self.inorder(root.left)
    self.traverse_path.append(root.val)
    self.inorder(root.right)

 def postorder(self, root):
    if root:
    self.postorder(root.left)
    self.postorder(root.right)
    self.traverse_path.append(root.val)

 * @author lixilong
 * @date 2019/11/28
 */
public class TreeOrder {

  //经典递归

  public void preOrder(TreeNode root) {
      if (root==null) return ;
      System.out.println(root.val);
      if (root.left!=null)  preOrder(root.left);
      if (root.right!=null)  preOrder(root.right);
  }

  public void inOrder(TreeNode root) {
      if (root==null) return ;

      if (root.left!=null)  inOrder(root.left);
      System.out.println(root.val);
      if (root.right!=null)  inOrder(root.right);
  }

  public void postOrder(TreeNode root) {
    if (root==null) return ;

    if (root.left!=null)  postOrder(root.left);
    if (root.right!=null)  postOrder(root.right);
    System.out.println(root.val);
  }

  //栈递归
//  def inorderTraversal(self, root: TreeNode) -> List[int]:
//  WHITE, GRAY = 0, 1
//  res = []
//  stack = [(WHITE, root)]
//      while stack:
//  color, node = stack.pop()
//      if node is None: continue
//      if color == WHITE:
//      stack.append((WHITE, node.right))
//      stack.append((GRAY, node))
//      stack.append((WHITE, node.left))
//      else:
//      res.append(node.val)
//      return res
//
//  作者：hzhu212
//  链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


  //层次遍历

  //  迭代
  public void levelTraversal(TreeNode root) {
    LinkedList queue = new LinkedList<TreeNode>();
    queue.add(queue);

    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
      if (root.left != null)  queue.add(root.left);
      if (root.right != null)  queue.add(root.right);
    }
  }
//
//  List<List<Integer>> levels = new ArrayList<List<Integer>>();
//
//  public void helper(TreeNode node, int level) {
//    // start the current level
//    if (levels.size() == level)
//      levels.add(new ArrayList<Integer>());
//
//    // fulfil the current level
//    levels.get(level).add(node.val);
//
//    // process child nodes for the next level
//    if (node.left != null)
//      helper(node.left, level + 1);
//    if (node.right != null)
//      helper(node.right, level + 1);
//  }
//
//  public List<List<Integer>> levelOrder(TreeNode root) {
//    if (root == null) return levels;
//    helper(root, 0);
//    return levels;
//  }
//
//  作者：LeetCode
//  链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-ci-bian-li-by-leetcode/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


  // N叉树的层次遍历
//  public void levelTraversal2(TreeNode root) {
//    if (root == null) return;
//    helper(root,0);
//  }
//
//  private void helper(TreeNode root, int depth) {
//    if (root == null) return;
//    if (depth+1)
//  }



  }

