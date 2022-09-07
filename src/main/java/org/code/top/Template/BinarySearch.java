package main.java.org.code.top.Template;

/**
 * describe:
 * 条件(3个)：
 * sorted + bounded + accessible by index
 *
 *
 *
 * 应用case：
 * 二分查找只适用顺序存储结构（所以数组很适合，链表不适合）。
 *
 * 主体逻辑：


   left, right = 0, len(array) - 1
   while left <= right:
      mid = (left + right) / 2
   if array[mid] == target:
      # find the target!!
      break or return result
   elif array[mid] < target:
        left = mid + 1
   else:
        right = mid - 1


 * @author lixilong
 * @date 2019/01/19
 */
public class BinarySearch {


  //递归
  public int binarySearch1(int[] array, int target, int left, int right) {
    int mid = (right - left) >> 1 + left;
    if (target == array[mid]) return array[mid];
    else if (target < array[mid])
       return binarySearch1(array,target,left,mid-1);
    else
       return binarySearch1(array,target,mid+1,right);
  }


  //迭代
  public int binarySearch2(int[] array, int target) {
    int left = 0, mid = 0, right = array.length - 1;

    while (left <= right) {
      mid = (right - left) >> 1 + left;
      if (array[left] == target)
        return left;
       else if (left < target)
        left = mid + 1;
       else
         right = mid - 1;
    }

    return -1;
  }


}
