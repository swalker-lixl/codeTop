package main.java.org.code.top;

import java.util.Arrays;

/**
 * describe:
 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

 示例 1:

 输入: coins = [1, 2, 5], amount = 11
 输出: 3
 解释: 11 = 5 + 5 + 1
 示例 2:

 输入: coins = [2], amount = 3
 输出: -1
 说明:
 你可以认为每种硬币的数量是无限的。

 * @author lixilong
 * @date 2019/01/28
 */
public class _lc_322_CoinChange {


//官方解释和代码: https://leetcode.com/problems/coin-change/solution/

  // Runtime: 19 ms, faster than 62.72%

  /**
   * 递归
   * 广度优先遍历，Min（层数）就是硬币个数
   * DP
   *   subProblem
   *   状态数组：状态树
   *   Dp array: f(n) = min(f(n-k), for k in [1,2,5]) +1
   *
   *   DP转移方程:
   *
   * */
    public int coinChange1(int[] coins, int amount) {
      int max = amount + 1;
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, max);

      dp[0] = 0;
      for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
          if (coins[j] <= i) {
            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
          }
        }
      }
      return dp[amount] > amount ? -1 : dp[amount];
    }

//  Runtime: 14 ms, faster than 97.10%
  private static int MAX = 100000000;

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, MAX);
    dp[0] = 0;
    for(int c : coins) {
      for(int i = c; i <= amount; i++) {
        dp[i] = Math.min(dp[i], dp[i - c] + 1);
      }
    }
    return dp[amount] == MAX ? -1 : dp[amount];
  }

}
