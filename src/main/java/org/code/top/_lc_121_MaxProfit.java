package main.java.org.code.top;

/**
 * describe:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author lixilong
 * @date 2019/01/28
 */
public class _lc_121_MaxProfit {

  //官方解法： https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/

  //  Runtime: 1 ms, faster than 99.88%
  //  使我们感兴趣的点是上图中的峰和谷。我们需要找到最小的谷之后的最大的峰。
  //  我们可以维持两个变量——minprice 和 maxprofit，
  //  它们分别对应迄今为止所得到的最小的谷值和最大的利润（卖出价格与最低价格之间的最大差值）。

  public int maxProfit1(int prices[]) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minprice)
        minprice = prices[i];
      else if (prices[i] - minprice > maxprofit)
        maxprofit = prices[i] - minprice;
    }

    return maxprofit;
  }


//  方法2：暴力法
//  我们需要找出给定数组中两个数字之间的最大差值（即，最大利润）。
//  此外，第二个数字（卖出价格）必须大于第一个数字（买入价格）。
    public int maxProfit(int prices[]) {
      int maxprofit = 0;
      for (int i = 0; i < prices.length - 1; i++) {
        for (int j = i + 1; j < prices.length; j++) {
          int profit = prices[j] - prices[i];
          if (profit > maxprofit)
            maxprofit = profit;
        }
      }
      return maxprofit;
    }
}
