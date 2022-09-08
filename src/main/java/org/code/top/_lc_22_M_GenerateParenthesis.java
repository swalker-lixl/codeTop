package main.java.org.code.top;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *  给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _lc_22_M_GenerateParenthesis {


/*
* 方法1 ：数学归纳法
* 方法2 ：构建一个2*N大小的数组，对所有可能组合筛选
* 方法3 ：剪枝：在2的基础上改进
*
*
* */

// 方法1： Simple Java DFS solution
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList();
    dfs(n, n, result, "");
    return result;
  }

  private void dfs(int left, int right, List<String> result, String s) {
    if (left == 0 && right == 0) {
      result.add(s); //单个括号序列生成完毕
    } else {
      if (left > 0)
        dfs(left - 1, right, result, s + "("); //递归压左边
      if (right > left)
        dfs(left, right - 1, result, s + ")");//递归压右边
    }
  }


}
