package main.java.org.code.top;

import java.util.Arrays;

/**
 * describe:
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 *
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 *
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/heaters
 *
 *  @author lixilong
 * @date 2019/11/15
 */
public class _lc_475_FindRadius {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int j = 0;
        int max = -1;
        for (int i = 0; i < houses.length; i++) {
            if ((j + 1 < heaters.length) && (Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1]))) {
                j++;
                i--;
            } else if (max < Math.abs(houses[i] - heaters[j]))
                max = Math.abs(houses[i] - heaters[j]);
        }
        return max;
    }


}
