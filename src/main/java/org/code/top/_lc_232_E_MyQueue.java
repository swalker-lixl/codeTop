package main.java.org.code.top;

import java.util.Stack;

/**
 * describe:
 *
 *
 *
 * 参考分析英文原文：
 *  https://leetcode.com/problems/implement-queue-using-stacks/discuss/219033/Java-Solution%3A-Using-Two-Stacks-O(1)-amortized-time
 * @author lixilong
 * @date 2019/01/23
 */
public class _lc_232_E_MyQueue {

 //方法1： 在push中直接操作，记住方法1即可，两个栈实现队列的最终输出状态
//  两个栈，用它们其中一个来反转元素的入队顺序，用另一个来存储元素的最终顺序。
//  入队 - O(n)， 出队 - O(1)

  private Stack<Integer> s1 = new Stack<Integer>();
  private Stack<Integer> s2 = new Stack<Integer>();


  //* Push element x to the back of queue.
  public void push(int x) { //任何时可总有一个空栈，用来压入后调整到另一个栈栈顶
    if (s1.isEmpty()) {
      s1.push(x);
      for (int i = 1; i < s1.size(); i++) {
        s2.push(s1.pop());
      }
    } else {
      s2.push(x);
      for (int i = 1; i < s2.size(); i++) {
        s1.push(s2.pop());
      }
    }

  }

  //* Removes the element from in front of queue and returns that element.
  public int pop() {
    return s1.isEmpty() ? s2.pop() : s1.pop();
  }

  //* Get the front element.
  public int peek() {
    return s1.isEmpty() ? s2.peek() : s1.peek();
  }

  //* Returns whether the queue is empty.
  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }

  //方法2： push不做处理，第一次访问的函数中专门操作



}
