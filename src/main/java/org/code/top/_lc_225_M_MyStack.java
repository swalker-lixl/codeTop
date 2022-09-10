package main.java.org.code.top;

import java.util.LinkedList;
import java.util.Queue;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/23
 */
public class _lc_225_M_MyStack {

//1.数组实现

  //1.队列实现 两个队列,画图解释看 两个队列实现栈的最终输出状态


  // $ 新来的元素让其成为第一个，其余的顺序跟在后头
  private Queue<Integer> q1 = new LinkedList<Integer>();
  private Queue<Integer> q2 = new LinkedList<Integer>();
  public void push(int x) {
    if(q1.isEmpty()) {  //两个queue轮换着添加加入元素，每次加入后，另一个队列的值全部挪动到当前队列（新加元素后面）
      //任何时刻，均是一个空queue和一个满queue【新加元素在队首】
      q1.add(x);
      for(int i = 0; i < q2.size(); i ++)
        q1.add(q2.poll());
    }else {
      q2.add(x);
      for(int i = 0; i < q1.size(); i++)
        q2.add(q1.poll());
    }
  }

  public void pop() {
    if(!q1.isEmpty())
      q1.poll();
    else
      q2.poll();
  }

  public int top() {
    return q1.isEmpty() ? q2.peek() : q1.peek();
  }
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }

}
