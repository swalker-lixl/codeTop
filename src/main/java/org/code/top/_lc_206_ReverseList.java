package main.java.org.code.top;

import main.java.org.code.top.util.ListNode;

/**
 * describe:
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 *
 * refrence resources: https://leetcode.com/problems/reverse-linked-list/
 *
 * 链表翻转操作的顺序
 *  对于迭代来说是从链头往链尾，而对于递归是从链尾往链头
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _lc_206_ReverseList {


  //方法一：迭代 // 记住这个写法即可[代码超过十行]
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head; //链表为空或者仅1个数直接返回

    ListNode cur = head,  newH = null;
    while (cur != null) {  //从头开始一直迭代到链尾,判断一次尾指针，退出时，newH已经为cur更新
      ListNode tmp = cur.next;         //暂存p下一个地址，防止变化指针指向后找不到后续的数
      cur.next = newH;                //p.next指向前一个空间

      newH = cur;                     //新链表的头移动到p，扩长一步链表【tips:更新链表要从后往前】
      cur   = tmp;                    //p指向原始链表p指向的下一个空间
    }
    return newH;
  }














//  方法二：递归
//  作者：LeetCode
   /*
   链接：https://www.nowcoder.com/questionTerminal/75e878df47f24fdc9dc3e400ec6058ca
   本题的关键就是在于对next域的赋值，同时对下一个节点进行保存，然后对把下一个节点赋给新的节点，这样依次循环完所有的节点。
   每次使新插入的节点变成头第一个有效节点。核心代码如下：
    next = current.next;
    current.next = reverhead;
    reverhead = current;
    current = next;
 */
public ListNode reverseList1(ListNode head) {
  if (head == null || head.next == null) return head; //链表为空或者仅1个数直接返回
  ListNode newHead = reverseList1(head.next);   //一直循环到链尾
  head.next.next = head;                         //翻转链表的指向
  head.next = null;                             //记得赋值NULL，防止链表错乱

  return newHead;                               //新链表头永远指向的是原链表的链尾
}
//  版权声明：本文为CSDN博主「无鞋童鞋」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//  原文链接：https://blog.csdn.net/FX677588/article/details/72357389


}
