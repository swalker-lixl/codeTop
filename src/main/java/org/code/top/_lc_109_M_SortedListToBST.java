package main.java.org.code.top;


import main.java.org.code.top.util.ListNode;
import main.java.org.code.top.util.TreeNode;

/**
 * describe:
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *
 * @author lixilong
 * @date 2019/12/29
 */
public class _lc_109_M_SortedListToBST {


//方法1
//  时间复杂度：O(N log N)
//  空间复杂度：O(log N)

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
   * x) { val = x; } }
   */
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {

    public TreeNode sortedListToBST(ListNode head) {
      // If the head doesn't exist, then the linked list is empty
      if (head == null)   return null;

      // Find the middle element for the list.
      ListNode mid = this.findMiddleElement(head);

      // The mid becomes the root of the BST.
      TreeNode node = new TreeNode(mid.val);

      // Base case when there is just one element in the linked list
      if (head == mid)  return node;

      // Recursively form balanced BSTs using the left and right halves of the original list.
      node.left = this.sortedListToBST(head);
      node.right = this.sortedListToBST(mid.next);
      return node;
    }

    private ListNode findMiddleElement(ListNode head) {
      // The pointer used to disconnect the left half from the mid node.
      ListNode prevPtr = null, slowPtr = head, fastPtr = head;
      // Iterate until fastPr doesn't reach the end of the linked list.
      while (fastPtr != null && fastPtr.next != null) {
        prevPtr = slowPtr; //根节点
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next.next;
      }

      // Handling the case when slowPtr was equal to head.
      if (prevPtr != null) {
        prevPtr.next = null;
      }

      return slowPtr;
    }


  }
//
//  作者：LeetCode
//  链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-shu-by-/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
