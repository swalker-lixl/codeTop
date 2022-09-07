package main.java.org.code.top.util;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/11/29
 */
public class MyArray {

  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[j];
    arr[i] = arr[j];
    arr[j] = tmp;
  }



}
