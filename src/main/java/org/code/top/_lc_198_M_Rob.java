package main.java.org.code.top;

/**
 * describe:
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author lixilong
 * @date 2019/12/24
 */
public class _lc_198_M_Rob {


/**
 *
 * DP
 *  找到重复子问题
 *  找到最优子结构
 *  转移方程
 *
 *  a[i] : 0 .... 1 ,能偷到max_value: a[n-1]
 *  a[i][0,1] 0:不偷，1：偷 // 加一个维度定义状态
 *
 *  a[i][0] = max(a[i-1][0], a[i-1][1])
 *  a[i][1] = a[i-1][0] + nums[i]
 *
 * */

  public int rob(int[] nums) {
    int len = nums.length;
    int[][] dp = new int[len][2];
    dp[0][0] = 0;
    dp[0][1] = nums[0];

    for (int i = 1; i < len; i++) {
      dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
      dp[i][1] = dp[i][0] + nums[i];
    }

    return Math.max(dp[len-1][0],dp[len -1][1]);
  }


  /**
   *  当n = 1的情况下, 显然f(1) = A1;
   *  再看 n = 2, f(2) = max(A1, A2)
   *  对于 n = 3, 有两个选项：
   *    抢第三个房子，将数额与第一个房子相加
   *    不抢第三个房子，保持现有最大金额
   *
   *  f(-1) = f(0) = 0;
   *  f[i] = max(f[k-2], f[i-2] + num[i])
   * */

  public int rob3(int[] num) {
    int prevMax = 0, currMax = 0;

    for (int x : num) {
      int temp = currMax;
      currMax = Math.max(prevMax + x, currMax);
      prevMax = temp;
    }

    return currMax;
  }

  /**
   * https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode/
   * DP
   *  找到重复子问
   *  状态空间的定义很提现内功
   *  转移方程
   *
   *  a[i] : 0 .... 1 ,能偷到max_value: a[n-1]
   *
   *  a[i] = max(a[i-1], a[i-2]+num[i])
   *
   * */

  public int rob2(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    if (nums[0] == 1)
      return nums[0];

    int len = nums.length;
    int[] dp = new int[len];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[1], nums[1]);

    int res = Math.max(dp[0], dp[1]);
    for (int i = 2; i < len; i++) {
      dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
      res = Math.max(res, dp[i]);
    }

    return res;
  }




}
