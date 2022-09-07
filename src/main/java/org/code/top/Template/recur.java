package main.java.org.code.top.Template;

/**
 * describe:
 *
 *   //   递归代码模板

 public void recur() {
 //terminator， 终结者
 if (level  > MAX_LEVEL) return;     // process result

 //process current logic， 当前逻辑处理
 process(level,param);

 //drill down， 递归下降
 recur(level,param);

 //process current status, 恢复当前层处理状态
 }

 * @author lixilong
 * @date 2019/11/17
 */
public class recur {

  /**
   *




   分治代码模板：本质是寻找重复性（利用计算机指令集）
   代码有自相似性

   //  面试题肯定在 10~30 行以内
   //  找到最近最简方法，拆解可重复解决的问题
   //  如实在找不到思路，通过数学归纳法总结规律（避免人肉递归【状态树】）

   public void divide_conquer(Object problem) {

   //recursion terminator， 终结者
   if (problem == null) return;     // process result

   //prepare data， 当前逻辑处理
   data = prepare_data(problem);
   subproblems = split_problem(problem,data);

   // conquer subproblems
   subresult1 = divide_conquer(subproblems[0],p1);
   subresult2 = divide_conquer(subproblems[1],p1);
   subresult3 = divide_conquer(subproblems[2],p1);

   //process adn generate the final result
   result = process_result(subresult1, subresult2, subresult3);

   //revet the current level status, 恢复当前层处理状态
   }

   */

  //  动态规划核心：分治+最优子结构
  //  本质和递归/分治无差别，在于是否有最优子结构区分开
  //  共性：找到重复子问题
  //  差异性：最优子结构、中途可以也必须淘汰次优解

//  最优子结构： opt[n] = best_of(opt[n-1],opt[n-2])
//  储存中间状态：opt[i]
//  递推公式：Fib: opt[] = opt[] + opt[];
//           二维：opt[] = opt[] + opt[];
//
//  //自底向上，直接for循环【递归优先考虑】
//
//  //count paths
//  //状态转移方程（DP方程），optimal:最右解
//
//  完整逻辑：
//  if a[i][j] = "空地"：
//      opt[i,j] = opt[i+1,j] + opt[i,j+1]；
//  else
//      opt[i,j] = 0;

//  总结











//  状态空间的定义提现基本功

//  house-
//  二维数组，一步一步过渡过来，然后思维训练
//
//
//
//  股票问题：看算法40讲 的通解解法
//  一个方法团灭6道题
//  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
//
//
//  edit-distance
//
//
//  动态规划小结
//      以前看大神代码，简直跪拜，直接强行记忆发现效果并不理想。
//      听完超哥DP分享，解法讲求稳扎稳打，从递推方程、状态空间一步一步过渡过来，然后强化训练成通法。
//
//      动态规划核心：分治+最优子结构
//      本质和递归/分治无差别，在于是否有最优子结构区分开
//      共性：找到重复子问题
//      差异性：最优子结构、中途可以也必须淘汰次优解
//
//      最优子结构： opt[n] = best_of(opt[n-1],opt[n-2])
//      储存中间状态：opt[i]
//      递推公式：Fib: opt[] = opt[] + opt[];
//               二维：opt[] = opt[] + opt[];
//
//      自底向上，直接for循环【这种写法要落手即成】
//
//
//  冒泡排序、插入排序、选择排序这三种排序算法，它们的时间复杂度都是 O(n )，比较高，适合小规模数据的排序。
//  归并排序和快速排序，两种排序算法适合大规模的数据排序。
//  快排：每过一遍，基准元素都会找到自己位置
  public static void main(String[] args) {
    int left = 2, right = 4;
    int mid1 = left + (right - left) >> 1;
    int mid4 = left + ((right - left) >> 1);
    int mid2 = left + (right - left)/2;
    int mid3 = (right + left)/2;

    System.out.println("mid1 = left + (right - left) >> 1; "+mid1);
    System.out.println("mid2 = left + (right - left)/2; " + mid2);
    System.out.println("mid3 = (right + left)/2; " + mid3);
    System.out.println("mid3 = (right + left)/2; " + mid4);

  }

}
