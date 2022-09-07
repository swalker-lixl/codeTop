package main.java.org.code.top.Template;

import java.util.Scanner;

/**
 * describe:
 * 条件(3个)：
 *
 *
 * 应用case：
 * 二分查找的四个变形题。
 *
 * 主体逻辑：
 *
 *
 * @author lixilong
 * @date 2019/01/19
 */
public class BinarySearch2 {


  //1.标准二分：查找一个值等于给定值的元素（ 序数据集合中不存在重复的数据）
  public int binarySearch2(int[] array, int target) {
    int left = 0, mid = 0, right = array.length - 1;

    while (left <= right) {
      mid = (right - left) >> 1 + left;
      if (array[mid] == target)
        return array[mid];
       else if (array[mid] < target)
        left = mid + 1;
       else
         right = mid - 1;
    }

    return -1;
  }


  //2.变式：查找第一个值等于给定值的元素（ 存在重复的数据）
  public int binarySearch3(int[] array, int target) {
    int left = 0, mid = 0, right = array.length - 1;

    while (left <= right) {
      mid = (right - left) >> 1 + left;

        if (array[mid] < target) {
          left = mid + 1;
        }else if (array[mid] > target) {
          right = mid - 1;
        }else { //相等的前提下
          if (mid == 0 || (array[mid - 1] != target)) { //第一个值等于给定值的元素
            return mid;
          }else {
            right = mid - 1; //往前找
          }
        }
    }

    return -1;
  }



  //3.变式：查找最后一个值等于给定值的元素（ 存在重复的数据）
  public int binarySearch5(int[] array, int target) {
    int left = 0, mid = 0, right = array.length - 1;

    while (left <= right) {
      mid = (right - left) >> 1 + left;

      if (array[mid] < target) {
        left = mid + 1;
      }else if (array[mid] > target) {
        right = mid - 1;
      }else { //相等的前提下
        if (mid == array.length-1 || (array[mid + 1] != target)) {
          return mid;
        }else {
          left = mid + 1; //往后找
        }
      }
    }

    return -1;
  }

  //4.变式：查找第一个大于等于给定值的元素（ 存在重复的数据）
  public int binarySearch4(int[] array, int target) {
    int left = 0, mid = 0, right = array.length - 1;

    while (left <= right) {
      mid = (right - left) >> 1 + left;

      if (array[mid] >= target) {
        if (mid == array.length-1 || (array[mid + 1] != target)) {
          return mid;
        }else {
          right = mid - 1;
        }
      }else {
        left = mid + 1; //往后找
      }
    }

    return -1;
  }


  //5.变式：查找最后一个小于等于给定值的元素（ 存在重复的数据）
  public int binarySearch6(int[] array, int target) {
    int left = 0, mid = 0, right = array.length - 1;

    while (left <= right) {
      mid = (right - left) >> 1 + left;

      if (array[mid] <= target) {
        if (mid == array.length-1 || (array[mid + 1] != target)) {
          return mid;
        }else {
          left = mid + 1;
        }
      }else {//当前值比 参考值 大， 往前找
        right = mid - 1;
      }
    }

    return -1;
  }


















  public static void main(String[] args) {



    while (true) {

      Scanner scanner = new Scanner(System.in);
      int a = scanner.nextInt();
      int b = scanner.nextInt();

//      if (a > b) {
//        System.out.println("a > b: " + a);
//      }else if (a < b){
//        System.out.println("a < b: " + b);
//      }else {
//        System.out.println("a == b: " + a + " " + b);
//      }

//      int m = a - b;
//      if (m < 0) {
//        System.out.println("a < b: " + a);
//      } else if (m == 0) {
//        System.out.println("a == b: " + b);
//      } else {
//        if (m > 1) {
//          System.out.println("哈哈哈哈");
//        } else {
//          System.out.println("a < b: " + a + " " + b);
//        }
//      }


      int m = a - b;
      if (m < 0) {
        System.out.println("a < b: " + a);
      } else if (m == 0) {
        System.out.println("a == b: " + b);
      } else if (m > 1){
        System.out.println("哈哈哈哈");
      } else {
          System.out.println("a < b: " + a + " " + b);
        }
      }
    }




}
