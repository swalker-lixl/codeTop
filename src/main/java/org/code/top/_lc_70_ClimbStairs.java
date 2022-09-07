package main.java.org.code.top;

/**
 * describe:
 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶


 * @author lixilong
 * @date 2019/01/27
 */
public class _lc_70_ClimbStairs {

  //Runtime: 3 ms, faster than 36.57%
  public int climbStairs(int n) {
    if (n == 1)
      return 1;

    int first = 1; int second = 2;
    for (int i = 3; i <= n; i++) {
      int third = first + second;
      first = second;
      second = third;
    }
    return second;
  }

// Runtime: 2 ms, faster than 100.00%
  public int climbStairs2(int n) {
    if (n == 1)
      return 1;

    int[] dp = new int[n + 1];
    dp[1] = 1; dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }


  //变式题：相邻步伐不相同,待改善验证
  public int climbStairs5(int n) {
    if (n == 1)
      return 1;
    int[] status = {0, 1};
    int[][] dp = new int[n + 1][2];
    dp[1][0] = 0;
    dp[1][1] = 1;
    dp[2][0] = 1;
    dp[2][1] = 1;

    for (int i = 3; i <= n; i++) {
      dp[i][0] = dp[i - 1][0] + dp[i - 2][0] + dp[i - 2][1];
      dp[i][1] = dp[i - 1][0] + dp[i - 2][0] + dp[i - 2][1];
    }
    return dp[n][0] + dp[n][1];
  }


  //变式题：可以走三步
  public int climbStairs3(int n) {
    if (n == 1)
      return 1;

    int[] dp = new int[n + 1];
    dp[1] = 1; dp[2] = 2; dp[2] = 3;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i-3];
    }
    return dp[n];
  }

  //变式题：每次步数是数组中任意值 arry[]
  public int climbStairs4(int n,int[] nums) {
    if (n == 1)
      return 1;

    int[] dp = new int[n + 1];
    dp[1] = 1; dp[2] = 2; dp[2] = 3;

    for (int i = 3; i <= n; i++) {
      for (int step: nums) {
        dp[i] += dp[i - step];
      }
    }

    return dp[n];
  }


}
