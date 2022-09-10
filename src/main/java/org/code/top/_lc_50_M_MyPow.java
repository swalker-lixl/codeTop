package main.java.org.code.top;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/01/25
 */
public class _lc_50_M_MyPow {

//方法1： 调用库函数
  public double myPow(double x, int n) {
    return Math.pow(x,n);
  }


  //方法5： AC 二分
  public double myPow5(double x, int n) {
    if(n == 0) return 1.0;
    double d = myPow5(x, n/2);

    if (n % 2 == 0)
      return d*d;
    if (n < 0)
      return d*d*(1/x);

    return d*d*x;
  }

//方法2： 暴力傻乘
  public double myPow2(double x, int n) {
    double res = 1.0;
    if (n == 0)  return res;
    else if (n < 0)
      for (int i = n; i < 0; i++)   res *= 1/x;
    else
      for (int i = 0; i < n; i++)   res *= x;

    return res;
  }

  //运行时间：48ms  占用内存：10368k
  public double myPow7(double x, int n) {
    /*链接：https://www.nowcoder.com/questionTerminal/1a834e5e3e1a4b7ba251417554e07c00
    来源：牛客网
    幂运算
    */
    long  power = Math.abs(n);
    double r = 1.0;
    while(power > 0 ){
      if((power & 1) > 0) r *= x;  //关键两句话 1：
      x *= x;
      power >>= 1; //关键两句话 2：
    }
    return n < 0 ? 1/ r : r;
  }

  //方法6：  AC Runtime: 9 ms, faster than 80.73% of Java online submissions for Pow(x, n).
  public double myPow6(double x, int n) {
    if(n == 0) return 1;

    if(n < 0){
      x = 1 / x;
      if(n == Integer.MIN_VALUE)
        return x * myPow6(x, Integer.MAX_VALUE);
      else n = -n;
    }

    if(n % 2 == 0) return myPow(x * x, n / 2);
    else return x * myPow(x * x, n / 2);
  }



//  ==============================================================================================================
//方法3： 二分 分奇偶数两种情形
/*
  Runtime Error Message:
  Line 7: java.lang.StackOverflowError
  Last executed input:
      1.00000
      -2147483648
 */
  public double myPow3(double x, int n) {
    double res = 1.0;

    if (n == 0)
      return res;

    else if (n < 0)
          res = 1 / myPow3( x, -n);
         else  if (n % 2 != 0)
               res = x * myPow3(x, n - 1);
              else
                res = myPow3(x * x, n / 2);

    return res;
  }

//方法4：循环写法 ：
  /*
  测试case过不去
    Input:
        2.00000
        -2147483648
    Output:
        1.0
    Expected:
        0.0
  */
 public double myPow4(double x, int n) {
   if (n < 0) {
     x = 1 / x;
     n = -n;
   }

   double pow = 1.0;

   while (n > 0) {
     if ((n & 1) > 0)   pow *= x;
     x *= x;
     n = n >> 1;  // n >> 1表示 n /2
   }

   return pow;
 }



}
