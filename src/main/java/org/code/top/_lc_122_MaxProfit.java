package main.java.org.code.top;

/**
 * describe:
 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 示例 1:
 输入: [7,1,5,3,6,4]
 输出: 7
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

 示例 2:
 输入: [1,2,3,4,5]
 输出: 4
 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

 示例 3:
 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 * @author lixilong
 * @date 2019/01/25
 */
public class _lc_122_MaxProfit {

  //官方解法： https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/

  //方法3：贪心算法，只要后一天比前一天大，就前一天买进，后一天卖出，利润就是差之和
  //“等价于每天都买卖”，这种理解好，把可能跨越多天的买卖都化解成相邻两天的买卖
  public int maxProfit(int[] prices) {
    int maxprofit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1])    //抛开干扰因素,只关心最大获利，每天可以无数次买进卖出。
        maxprofit += prices[i] - prices[i - 1]; // 所以能拿到最新差价
    }
    return maxprofit;
  }


//方法1：Time Limit Exceeded  Approach 1: Brute Force
  public int maxProfit2(int[] prices) {
    return calculate(prices, 0);
  }

  public int calculate(int prices[], int s) {
    if (s >= prices.length)
      return 0;
    int max = 0;
    for (int start = s; start < prices.length; start++) {
      int maxprofit = 0;
      for (int i = start + 1; i < prices.length; i++) {
        if (prices[start] < prices[i]) {
          int profit = calculate(prices, i + 1) + prices[i] - prices[start];
          if (profit > maxprofit)
            maxprofit = profit;
        }
      }
      if (maxprofit > max)
        max = maxprofit;
    }
    return max;
  }

//方法2：
  public int maxProfit3(int[] prices) {
    if (prices.length <= 0) return 0;
    int i = 0;
    int valley = prices[0];
    int peak = prices[0];
    int maxprofit = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1])
        i++;
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1])
        i++;
      peak = prices[i];
      maxprofit += peak - valley;
    }
    return maxprofit;
  }


}
