package main.java.org.code.top;

import java.util.Scanner;

/**
 * describe:
 *时间限制：1秒 空间限制：32768K 热度指数：308489
 链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/

 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author lixilong
 * @date 2019/01/10
 */
public class _lc_191_HammingWeight {



//  解法四：模拟十转二进制、取模
  public int hammingWeight3(int n) {
   int count = 0;
    while(n > 0){
      if((n & 1) == 1){      // n % 2 == 1
        count++;
      }
      n >>>= 1;
    }
    return count;
  }

/*
  作者：Alexer-660
  链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/191-wei-1de-ge-shu-by-alexer-660/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

  //方法 2：位操作的小技巧
  //位运算 计数
  public int hammingWeight2(int n) {
    int sum = 0;
    while (n != 0) { // 清零最低位的1，没有进位，所以没有越界问题
      sum++;
      n &= (n - 1);////每次运算后的n,后面位为0，只需要统计前面未统计的
    }
    return sum;
  }


  // Runtime: 1 ms, faster than 91.13%
  // 方法 1：循环和位移动
  public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) {
        bits++;//掩码作为统计1的个数，从最右边不断的左移直到首尾。
      }
      mask <<= 1;
    }
    return bits;
  }



  public void test(){
    int n;
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
//    System.out.println(hammingWeight(in));
  }

}
