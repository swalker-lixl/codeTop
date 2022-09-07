package main.java.org.code.top.Template;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * describe:
 * 接下来直接看，归并、快排、希尔排序
 * @author lixilong
 * @date 2019/01/11
 */
public class Sort {

  public static void main(String[] args) {
    double m = 1 >> 2;
    double n = 1 << 2;
    System.out.println("2 >> 1, "+ m);
    System.out.println("1 << 2, "+ n);
  }


  /*
  链接：https://www.nowcoder.com/questionTerminal/6a296eb82cf844ca8539b57c23e6e9bf
  参考Java实现：https://blog.csdn.net/wq_1995/article/details/81937926

  来源：牛客网
  八大排序：
  基数排序 快速排序 归并排序 堆排序 冒泡排序 直接选择排序 插入排序
  */


  public static void heapSort1(int[] array) {

    PriorityQueue q = new PriorityQueue( new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    for (int i = 0; i < array.length; i++) {
      q.add(array[i]);
    }

    for (int i = 0; i < array.length; i++) {
      array[i] = (int)q.poll();
    }
  }

  //堆排序
  public static void heapSort(int[] array) {
    if (array.length < 2) return;

    int length = array.length;
    for (int i = length / 2 - 1; i >= 0; i--) //1.构建一个最大堆
      heapify(array, length, i);

    for (int i = length - 1; i >= 0; i--) { //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
      int temp = array[0]; array[0] = array[i]; array[i] = temp;
      heapify(array, i, 0);
    }
  }

  private static void heapify(int[] array, int length, int i) {
    int left = 2 * i, right = 2 * i + 1;
    int largest = i;

    if (left < length && array[left] > array[largest])  largest = left;   //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
    if (right < length && array[right] > array[largest]) largest = right; //如果有右子树，且右子树大于父节点，则将最大指针指向右子树

    if (largest != i) {  //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
      int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
      heapify(array, length, largest);//递归，直到 父节点是最大节点
    }
  }



  //冒泡排序
  public static int[] bubleSort(int[] array) {
    if (array.length == 0) return array;
    for (int i=0; i < array.length; i++) {
      for (int j = i; j < array.length - i - 1; j++) { //注意二层范围
        if (array[j + 1] < array[j]) {
        int temp = array[j+1];
        array[j+1] = array[j];
        array[j] = temp;
        }
      }
    }
    return array;
  }




//归并排序
  public static void mergeSort(int[] array, int left, int right) {

    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);

  }

  public static void merge(int[] arr, int left, int mid, int right) {

    int[] temp = new int[right - left + 1]; // 中间数组
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
      temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }

    while (i <= mid)   temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];

    for (int p = 0; p < temp.length; p++) {
      arr[left + p] = temp[p];
    }
    // 也可以用 System.arraycopy(a, start1, b, start2, length)
  }



  /**
   * 归并排序
   *
   * @param array
   * @return
   */
  public static int[] MergeSort(int[] array) {
    if (array.length < 2) return array;
    int mid = array.length << 1;
    int[] left = Arrays.copyOfRange(array, 0, mid);
    int[] right = Arrays.copyOfRange(array, mid, array.length);
    return merge(MergeSort(left), MergeSort(right)); //分治递归
  }

  /**
   * 归并排序——将两段排序好的数组结合成一个排序数组
   *
   * @param left
   * @param right
   * @return
   */
  public static int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    for (int index = 0, i = 0, j = 0; index < result.length; index++) {
      if (i >= left.length)
        result[index] = right[j++];
      else if (j >= right.length)
        result[index] = left[i++];
      else if (left[i] > right[j])
        result[index] = right[j++];
      else
        result[index] = left[i++];
    }
    return result;
  }


  public static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
      if (a[i] < a[pivot]) {
        int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
        counter++;
      }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
  }

  /**
   * 快速排序方法
   * @param array
   * @return
   */
  public static void quickSort(int[] array) {
    if(array.length <2) return;
    quickHelp(array, 0, array.length - 1);
  }

  public static void quickHelp(int[] array, int left, int right) {
    if (left < right) {
      int parttion = partition(array, left, right);
      quickHelp(array, left, parttion - 1);
      quickHelp(array, parttion + 1, right);
    }
  }

  public static int parttion(int[] array, int left, int right) {
    int privoteKey = array[left], back = privoteKey;

    while (left<right) {
      while (privoteKey <= array[right] && left < right) {
        right--;
      }
      array[left] = array[right];
      //直到发现了有半部分有小于privotekey的数,采用替换
      while (array[left] <= privoteKey && left < right) {
        left++;
      }

      array[right] = array[left];
    }
    array[left] = back;
    return left;
  }


  /**
   * 交换数组内两个元素
   * @param array
   * @param i
   * @param j
   */
  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }




  //选择排序
  public static int[] selectionSort(int[] array) {
    if (array.length == 0) return array;
    for (int i = 0; i < array.length; i++) {
      int minIndex = i;
      for (int j = i; j < array.length; j++) {  //注意二层范围
        if (array[j] < array[minIndex]) //找到最小的数
          minIndex = j; //将最小数的索引保存
      }

      //放到已排序元素队尾
      int temp = array[minIndex];
      array[minIndex] = array[i];
      array[i] = temp;
    }
    return array;
  }

  //插入排序
  public static int[] insertionSort(int[] array) {
    if (array.length == 0) return array;
    int current;
    for (int i = 0; i < array.length - 1; i++) {
      current = array[i + 1];

      int preIndex = i;
      while (preIndex >= 0 && current < array[preIndex]) {
        array[preIndex + 1] = array[preIndex];
        preIndex--; //从后往前
      }

      array[preIndex + 1] = current; //从后往前找到第一个小于新元素的位置，插入前面元素位置后
    }
    return array;
  }


  //希尔排序：与插入排序的不同之处在于，它会优先比较距离较远的元素。了解思想即可
  public static int[] ShellSort(int[] array) {
    int len = array.length;
    int temp, gap = len / 2;
    while (gap > 0) {
      for (int i = gap; i < len; i++) {
        temp = array[i];
        int preIndex = i - gap;
        while (preIndex >= 0 && array[preIndex] > temp) {
          array[preIndex + gap] = array[preIndex];
          preIndex -= gap;
        }
        array[preIndex + gap] = temp;
      }
      gap /= 2;
    }
    return array;
  }


  /**
   * 计数排序
   *
   * @param array
   * @return
   */
  public static int[] CountingSort(int[] array) {
    if (array.length == 0) return array;
    int bias, min = array[0], max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > max)
        max = array[i];
      if (array[i] < min)
        min = array[i];
    }
    bias = 0 - min;
    int[] bucket = new int[max - min + 1];
    Arrays.fill(bucket, 0);
    for (int i = 0; i < array.length; i++) {
      bucket[array[i] + bias]++;
    }
    int index = 0, i = 0;
    while (index < array.length) {
      if (bucket[i] != 0) {
        array[index] = i - bias;
        bucket[i]--;
        index++;
      } else
        i++;
    }
    return array;
  }


}
