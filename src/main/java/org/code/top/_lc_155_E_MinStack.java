package main.java.org.code.top;

import java.util.Stack;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/10/29
 */
public class _lc_155_E_MinStack {

  /**
   * <p>
   *
   * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
   *
   *  push(x) -- 将元素 x 推入栈中。
   *  pop() -- 删除栈顶的元素。
   *  top() -- 获取栈顶元素。
   *  getMin() -- 检索栈中的最小元素。
   *
   *  示例:
   *
   * MinStack minStack = new MinStack();
   * minStack.push(-2);
   * minStack.push(0);
   * minStack.push(-3);
   * minStack.getMin();   --> 返回 -3.
   * minStack.pop();
   * minStack.top();      --> 返回 0.
   * minStack.getMin();   --> 返回 -2.
   *
   * </p>
   *
   * @author Seina
   * @version 2019-06-15 23:42:12
   */

    //java 中 int 的最大值
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;

    public _lc_155_E_MinStack(){
      stack = new Stack<Integer>();
    }

    public void push(int x) {
      if (x <= min) { //画调用过程就理解了
        // 当前压入元素小于当前最小值，故而需要先将此时最小值压入后再压入当前元素。在弹栈时，弹出上一个元素后，方便恢复之前的现场。
        stack.push(min);
        min = x; //更新 min
      }

      stack.push(x);// push x
    }

    public void pop(){ //维护min，时刻是当前主栈的最小值
      if (stack.pop() == min) min = stack.pop(); //如果 pop 的数等于 min，应该更新 min
    }

    public int top() {
      return stack.peek();
    }
    public int getMin(){
      return min;
    }


//  辅助栈法
/**
 private Stack<Integer> stack;
  private Stack<Integer> min_stack;
  public MinStack() {
    stack = new Stack<>();
    min_stack = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);
    if(min_stack.isEmpty() || x <= min_stack.peek())
      min_stack.push(x);
  }

  public void pop() { //维护最小栈，最小栈栈顶时刻是当前主栈的最小值
    if(stack.pop().equals(min_stack.peek()))
      min_stack.pop();
  }

  public int top() {
    return stack.peek();
  }
  public int getMin() {
    return min_stack.peek();
  }

  作者：jyd
  链接：https://leetcode-cn.com/problems/min-stack/solution/min-stack-fu-zhu-stackfa-by-jin407891080/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

}
