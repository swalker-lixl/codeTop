package main.java.org.code.top;

import main.java.org.code.top.util.ListNode;

/**
 * describe:
 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 示例 1:

 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 示例 2:

 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reorder-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 * @author lixilong
 * @date 2019/12/24
 */
public class _lc_143_M_ReorderList {
  //方法1:直接存储到数组，然后用双指针遍历得到一个新链表即可

  /**
   方法2：
  1 -> 2 -> 3 -> 4 -> 5 -> 6
  第一步，将链表平均分成两半
    1 -> 2 -> 3
    4 -> 5 -> 6

  第二步，将第二个链表逆序
    1 -> 2 -> 3
    6 -> 5 -> 4

  第三步，依次连接两个链表
    1 -> 6 -> 2 -> 5 -> 3 -> 4
   */


  public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }
    //找中点，链表分成两个
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode newHead = slow.next;
    slow.next = null;

    //第二个链表倒置
    newHead = reverseList(newHead);

    //链表节点依次连接
    while (newHead != null) {
      ListNode temp = newHead.next;
      newHead.next = head.next;

      head.next = newHead;

      head = newHead.next;
      newHead = temp;
    }

  }

  private ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode tail = head;
    head = head.next;

    tail.next = null;

    while (head != null) {
      ListNode temp = head.next;
      head.next = tail;
      tail = head;
      head = temp;
    }

    return tail;
  }

//
//  作者：windliang
//  链接：https://leetcode-cn.com/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
