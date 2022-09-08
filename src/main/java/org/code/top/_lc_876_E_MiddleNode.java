package main.java.org.code.top;


import main.java.org.code.top.util.ListNode;

/**
 * describe:
 *  机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人的最大欧式距离的平方。
 *
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _lc_876_E_MiddleNode {



 //方法一：先存数组，再利用下标
  public ListNode middleNode(ListNode head) {
    ListNode[] A = new ListNode[100];
    int t = 0;
    while (head.next != null) {
      A[t++] = head;
      head = head.next;
    }
    return A[t / 2];
  }


  //方法二：快慢指针
  public ListNode middleNode1(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) { //f.n 不为null, 返回位置始终是 (n+1)/2 奇偶个数都满足
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }


}
