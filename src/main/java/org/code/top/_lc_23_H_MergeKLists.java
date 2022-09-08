package main.java.org.code.top;

import main.java.org.code.top.util.ListNode;

/**
 * describe:
 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:

 输入:
 [
   1->4->5,
   1->3->4,
   2->6
 ]
 输出: 1->1->2->3->4->4->5->6

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @author lixilong
 * @date 2019/12/24
 */
public class _lc_23_H_MergeKLists {
/**
  方法 1：暴力

  遍历所有链表，将所有节点的值放到一个数组中。
  将这个数组排序，然后遍历所有元素得到正确顺序的值。
  用遍历得到的值，创建一个新的有序链表。
 */

//方法 2：逐一比较

//方法3：方法 4：逐一两两合并链表
//将合并 \text{k}k 个链表的问题转化成合并 2 个链表 \text{k-1}k-1 次。这里是 合并两个有序链表 的题目。

// 分治法
// https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/luo-ji-fei-chang-jian-dan-de-javati-jie-shi-jian-j/
// 每一次配对合并的过程中都会遍历几乎全部N 个节点，并重复这一过程 log(2K)次。
  public ListNode mergeKLists(ListNode[] lists) {
    int len = lists.length;
    if (len == 0) {
      return null;
    }
    // 将n个链表以中间为对称，合并，即合并
    while(len>1) {
      for (int i=0; i<len/2; i++) {
        lists[i] = mergeTwoLists(lists[i], lists[len-1-i]);
      }
      len = (len+1)/2;
    }
    return lists[0];
  }

  // 合并两个链表
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(-1);
    ListNode p = head;
    while(l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    if (l1 != null) {
      p.next = l1;
    } else if (l2 != null) {
      p.next = l2;
    }
    return head.next;
  }




}
