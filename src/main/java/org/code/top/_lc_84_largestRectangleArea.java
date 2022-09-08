package main.java.org.code.top;

import java.util.Stack;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/10/29
 */
public class _lc_84_largestRectangleArea {


  //  作者：LeetCode
  //  链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
  //  来源：力扣（LeetCode）


//  方法 5：栈  
  public int largestRectangleArea(int[] heights) {
    Stack< Integer > stack = new Stack < > ();
    stack.push(-1);
    int maxarea = 0;
    for (int i = 0; i < heights.length; ++i) {
      while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
        maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
      stack.push(i);
    }
    while (stack.peek() != -1)
      maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
    return maxarea;
  }



}
