package main.java.org.code.top;

import main.java.org.code.top.util.TreeNode;

import java.util.HashMap;

/**
 * describe:
 * 105. 从前序与中序遍历序列构造二叉树
 *
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * @author lixilong
 * @date 2019/10/27
 */
public class _lc_105_BuildTree {

  //方法一： 递归
  // start from first preorder element
  int pre_idx = 0;
  int[] preorder;
  int[] inorder;
  HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

  public TreeNode helper(int in_left, int in_right) {
    // if there is no elements to construct subtrees
    if (in_left == in_right) {
      return null;
    }

    // pick up pre_idx element as a root
    int root_val = preorder[pre_idx];
    TreeNode root = new TreeNode(root_val);

    // root splits inorder list
    // into left and right subtrees
    int index = idx_map.get(root_val);

    // recursion
    pre_idx++;
    // build left subtree
    root.left = helper(in_left, index);
    // build right subtree
    root.right = helper(index + 1, in_right);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    this.inorder = inorder;

    // build a hashmap value -> its index
    int idx = 0;
    for (Integer val : inorder) {
      idx_map.put(val, idx++);
    }
    return helper(0, inorder.length);
  }

}
