package main.java.org.code.top;

/**
 * describe:
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * @author lixilong
 * @date 2019/12/27
 */
public class _lc_260_M_SingleNumber {

    public static void main(String[] args) {
        _lc_260_M_SingleNumber singleNumber = new _lc_260_M_SingleNumber();
        int[] nums = {1, 2, 2, 4, 4, 5};

        System.out.println(singleNumber.singleNumber(nums)[0]);
        System.out.println(singleNumber.singleNumber(nums)[1]);
    }


    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums)// 一样的抵消,不一样的两个数字异或运算结果必定有一位是1
            xor ^= i;

        int mask = xor & (-xor); //可得到最低位的1,找到一个标志位作为掩码

        int[] ans = new int[2];
        for (int i : nums) {
            if ((i & mask) == 0)//== 0、 == mask 两种结果
                ans[0] ^= i;
            else
                ans[1] ^= i;
        }

        return ans;
    }

//  作者：StackOverflow-
//  链接：https://leetcode-cn.com/problems/single-number-iii/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-9/
}
