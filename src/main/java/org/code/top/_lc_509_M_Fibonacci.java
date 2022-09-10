package main.java.org.code.top;

/**
 * describe:
 *时间限制：1秒 空间限制：32768K 热度指数：420569
 *
 * 大家都知道斐波那契数列。 aN= a(N-1)+ a(N-2)  F[n]=F[n-1]+F[n-2] (n>=3,F[1]=1,F[2]=1)
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 *
 * @date 2019/11/17
 */
public class _lc_509_M_Fibonacci {

  /**  变式题
   *   1.有三种走法，每次走1步，2步，3步
   *   2.相邻两步不能相同
   *   https://shimo.im/docs/pXr9YwjPgpxdHrRT/read
   *
   */

  //方法1： 啥  运行时间：1425ms   占用内存：9080k
  public int fibonacci1(int n) {
    if (n > 39) {  //注意边界，39不认为是非法输入
      throw new RuntimeException("n should be lower 39 ! ");
    }

    return  n <= 1 ? n : fibonacci1(n - 1) + fibonacci1(n - 2);
  }

  //方法2： 递归优化 + 加缓存   运行时间：20ms 占用内存：9264k
  public int fibonacci2(int n) {
    if (n > 39)
      throw new RuntimeException("n should be lower 39 ! "); //注意边界，39不认为是非法输入

    if (n <= 1) return n; //注意边界，0 返回应该是0

    int[] memo = new int[n+1];
    if (memo[n] == 0)
      memo[n] = memo[n-1] + memo[n-2];

    return memo[n];
  }

  //方法2： 循环方式   运行时间：20ms 占用内存：9264k
  public int fibonacci3(int n) {
    if (n > 39)
      throw new RuntimeException("n should be lower 39 ! "); //注意边界，39不认为是非法输入

    if (n <= 1) return n; //注意边界，0 返回应该是0

    int[] memo = new int[n+1];
    memo[0] = 0; memo[1] = 1;
    for (int i = 2; i < n; i++)
        memo[i] = memo[n-1] + memo[n-2];
    return memo[n];
  }

  //方法3： 循环方式优化，不用数组   运行时间：20ms 占用内存：只记载 n-1,n-2
  public int fibonacci4(int n) {
    if (n > 39)
      throw new RuntimeException("n should be lower 39 ! "); //注意边界，39不认为是非法输入

    if (n <= 1) return n; //注意边界，0 返回应该是0
    int pre = 0, cur = 1, tmp = 0;

    for (int i = 2; i <= n; ++i)
      tmp = cur; cur += pre ; pre = tmp;

    return cur;
  }

}
