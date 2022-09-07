package main.java.org.code.top;

import main.java.org.code.top.util.ListNode;

/**
 * describe:
 * 面试题 02.07. 链表相交
 * 编写一个程序，找到两个单链表相交的起始节点。

 * @author lixilong
 * @date 2019/12/24
 */
public class _lc_160_GetIntersectionNode {


  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode pA = headA, pB = headB;

    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }

    return pA; //(pA == pB) 是退出循环的结论
    //不相交，不会死循环，最后都走到链表尾都是null了
    //所以相交返回具体节点，不想交会返回null
  }

//  作者：reals
//  链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


  /**
  如果两个链表相交，那么相交点之后的长度是相同的

  我们需要做的事情是，让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。
  为此，我们必须消除两个链表的长度差

  指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
  如果 pA 到了末尾，则 pA = headB 继续遍历
  如果 pB 到了末尾，则 pB = headA 继续遍历
  比较长的链表指针指向较短链表head时，长度差就消除了
  如此，只需要将最短链表遍历两次即可找到位置

  作者：reals
  链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

}
