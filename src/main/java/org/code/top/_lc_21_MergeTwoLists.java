package main.java.org.code.top;


import main.java.org.code.top.util.ListNode;

/**
 * describe:
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 *
 * https://leetcode.com/problems/valid-parentheses/description/
 * @author lixilong
 * @date 2019/01/23
 */
public class _lc_21_MergeTwoLists {


  /**
   * 递归
   *
   * 时间复杂度: O(m + n)
   * 空间复杂度: O(1)
   *
   * @param l1: 有序链表 l1
   * @param l2: 有序链表 l2
   * @return 合并之后新的有序链表
   */
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    //递归终止时，返回的是两个链表中最大的节点
    if (l1 == null)  return l2;
    else if (l2 == null) return l1;
    else if (l1.val < l2.val){
      l1.next = mergeTwoLists1(l1.next, l2); //每一层递归在做的事情：如果 l1 < l2，则越过 l1，也就是 l1 = l1.next; 否则 l2 = l2.next
      return l1;
    }else {
      l2.next = mergeTwoLists1(l1, l2.next);
      return l2;
    }

  }

  //拓展变式题-归并并去重，l1和l2可能有重复元素
  public ListNode mergeTwoLists1_1(ListNode l1, ListNode l2) {
    //递归终止时，返回的是两个链表中最大的节点
    if (l1 == null)  return l2;
    else if (l2 == null) return l1;
    else if (l1.val == l2.val){
      l1.next = mergeTwoLists1(l1.next, l2.next); //出现重复，选取l1中点即可，当然l2也可以
      return l1;
    }else if (l1.val < l2.val){
      l1.next = mergeTwoLists1_1(l1.next, l2);
      return l1;
    }else {
      l2.next = mergeTwoLists1_1(l1, l2.next);
      return l2;
    }

  }

  /**
   * 非递归
   *
   * 时间复杂度: O(n)
   * 空间复杂度: O(1)
   *
   * @param l1: 有序链表 l1
   * @param l2: 有序链表 l2
   * @return 合并之后新的有序链表
   */
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    ListNode prehead = new ListNode(-1);//$定义一个节点数据域是 -1 的节点
    ListNode p = prehead; //p 指针指向 -1 节点

    while (l1 != null && l2 != null) { //l1 和 l2 谁小，p.nexrt 就等于谁
      if (l1.val <= l2.val) {
        p.next = l1; //prehead 连接 l1
        l1 = l1.next; //继续判断 l1 的下一个节点
      }else {
        p.next = l2; //否则 prehead 连接 l2
        l2 = l2.next; //继续判断 l2 的下一个节点
      }
      p = p.next; //$
    }
    p.next = l1 == null ? l2 : l1; //把l1或l2长出来的元素跟在后面

    return prehead.next;//新链表第一个节点
  }


}
