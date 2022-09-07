package main.java.org.code.top.Template;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/12/24
 */
public class DP {

  /**
   * DP模板
   * 1. 最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], ...)
   * 2. 储存中间状态:opt[i]
   * 3. DP 方程
   *
   * Fib: opt[i] = opt[n-1] + opt[n-2]
   *
   * 二维路径:
   * opt[i,j] = opt[i+1][j] + opt[i][j+1] (且判断a[i,j]是否空地)
   *
   *
   *
   *
   1. “Simplifying a complicated problem by breaking it down into simpler sub-problems”
   (in a recursive manner)
   2. Divide & Conquer + Optimal substructure 分治 + 最优子结构
   3. 顺推形式: 动态递推



   function DP():
   dp = [][] # 二维情况
     for i = 0 .. M {
        for j = 0 .. N {
          dp[i][j] = _Function(dp[i’][j’]...)
        }
      }
   return dp[M][N];

   善于用一维、二维数组定义状态 dp[][]在面试中应用更广泛

   动态规划 和 递归或者分治 没有根本上的区别(关键看有无最优的子结构)
   拥有共性:找到重复子问题
   差异性:最优子结构、中途可以淘汰次优解

   *
   *
   *
   *
   *
   * */


}
