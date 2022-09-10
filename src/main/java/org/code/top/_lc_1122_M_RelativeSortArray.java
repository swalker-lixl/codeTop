package main.java.org.code.top;

/**
 * describe:
 给你两个数组，arr1 和 arr2，
 arr2 中的元素各不相同
 arr2 中的每个元素都出现在 arr1 中
 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 示例：
 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 输出：[2,2,2,1,4,3,3,9,6,7,19]
  

 提示：
 arr1.length, arr2.length <= 1000
 0 <= arr1[i], arr2[i] <= 1000
 arr2 中的元素 arr2[i] 各不相同
 arr2 中的每个元素 arr2[i] 都出现在 arr1 中

 * @author lixilong
 * @date 2019/12/01
 */
public class _lc_1122_M_RelativeSortArray {



  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] m = new int[1001];

    int[] ref = new int[arr1.length];//返回的目标

    for(int i = 0; i < arr1.length; i++)   m[arr1[i]]++; //分桶

    int cnt = 0;//返回目标数组中的索引，满足条件不断 inc—one

    for(int i = 0; i < arr2.length; i++) { //按arr2的顺序收集桶中的数组
      while (m[arr2[i]] > 0) {
        ref[cnt++] = arr2[i]; //对收集到的arr2做累计
        m[arr2[i]]--;
      }
    }

    for(int i = 0; i < 1001; i++) {
      while (m[i] > 0) { //升序顺序收集桶中剩余的数组
        ref[cnt++] = i;
        m[i]--;
      }
    }

    return ref;
  }

 /**
  *
  作者：nuan
  链接：https://leetcode-cn.com/problems/relative-sort-array/solution/java-chuang-jian-yi-ge-mapji-lu-arr1zhong-de-zhi-d/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

  */


}
