package main.java.org.code.top;

import main.java.org.code.top.util.ListNode;

/**

 ** describe:
 *  * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *  *
 *  * An input string is valid if:
 *  *
 *  * Open brackets must be closed by the same type of brackets.
 *  * Open brackets must be closed in the correct order.
 *  *
 *  *
 *  * https://leetcode.com/problems/valid-parentheses/description/
 *  * @author lixilong
 *  * @date 2019/01/23
 */
public class _lc_19_M_RemoveNthFromEnd {


  //方法2：双指针
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0); //一般留一行定义哨兵节点
    dummy.next = head;
    ListNode first = dummy, second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++)
      first = first.next;

    // Move first to the end, maintaining the gap
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;

    return dummy.next;
  }

}
