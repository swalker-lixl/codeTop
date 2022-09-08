package main.java.org.code.top;

import java.util.Arrays;

/**
 * describe:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * @author lixilong
 * @date 2019/11/17
 */
public class _lc_62_M_UniquePaths {

    public static void main(String[] args) {
        _lc_62_M_UniquePaths uniquePaths = new _lc_62_M_UniquePaths();
        System.out.println("uniquePaths.uniquePaths1(3,3): " + uniquePaths.uniquePaths1(3, 3));
        System.out.println("uniquePaths.uniquePaths2(3,3): " + uniquePaths.uniquePaths2(3, 3));
    }

    //找重复性 目的地是坐标原点
    // 对比 62题
    //  O(m*n)/O(m*n)
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) dp[0][i] = 1; //自底向上初始化
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)  //妈呀，居然把 m 和 n的遍历顺序整反了
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; //递推关系

        return dp[m - 1][n - 1];
    }


    //O(m*n)/O(n)
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];

        Arrays.fill(dp, 1);//初始化一行值

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) //对每行按列 操作，起始条件是从1开始，全1列和全1行已考虑过。
                dp[j] += dp[j - 1]; //只需要存最近一行，从当前行往上垒。 矩阵基本成对角线对称，所以对角求和能转换到当前行求和

        return dp[n - 1];
    }

}
