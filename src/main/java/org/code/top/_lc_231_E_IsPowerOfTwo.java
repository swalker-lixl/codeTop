package main.java.org.code.top;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class _lc_231_E_IsPowerOfTwo {

  //方法2： 取以2为底的对数
  //  直接调代码库
  //方法3： x&（x-1）==0，仅是判断而已
  // https://leetcode-cn.com/problems/power-of-two/solution/power-of-two-er-jin-zhi-ji-jian-by-jyd/
  public boolean isPowerOfTwo(int n) {
    return n <= 0 ? false : (n & (n - 1)) == 0;
  }

  //方法1： 不断%2，看最终结果是否为0
  public boolean isPowerOfTwo2(int n) {
    if (n <= 0) return false;
    if (n ==1)  return true;
    while(n > 1){
      if((n & 1) == 1) return false;
      n = n >> 1;
    }
    return true;
  }


}
