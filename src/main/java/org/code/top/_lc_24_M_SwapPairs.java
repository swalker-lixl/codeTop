package main.java.org.code.top;

import main.java.org.code.top.util.ListNode;

/**
 * describe:
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * <p>
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _lc_24_M_SwapPairs {


    //方法2：非递归
//  解题思路
//
//  我们首先需要建立pre、node1、node2和lat四个指针即可。
//
//  pre ->       node1  node2   lat
//         h  ->  1  ->  2  ->  3  ->  4
//      1
//      2
//  然后
// pre->next=node2;
// node2.next=node1;
// node1.next=lat
//
//     -----------
//         |         |
//  h    1 <- 2 -> 3 -> 4
//      |         |
//      -----------
//      ————————————————
//  原文链接：https://blog.csdn.net/qq_17550379/article/details/80675453

    public ListNode swapPairs1(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        while (pre.next != null && pre.next.next != null) { //p.n和p.n.n不能为空
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode lat = node2.next;

            pre.next = node2;
            node2.next = node1;
            node1.next = lat;

            pre = node1; //node1已经指向lat,即跨了两步
        }

        return pre.next;
    }


    //方法1：递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }


}
