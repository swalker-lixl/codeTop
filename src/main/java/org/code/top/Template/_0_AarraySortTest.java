package main.java.org.code.top.Template;

/**
 * describe:
 *
 * @author lixilong
 * @date 2019/12/06
 */
public class _0_AarraySortTest {

  private String com;
  private int id;

  public _0_AarraySortTest(int id, String com) {
    super();
    this.com = com;
    this.id = id;
  }

  @Override
  public String toString() {
    return "TestCompare [com=" + com + ", id=" + id + "]";
  }


  public static void main(String[] args) {
    System.out.println(8 >>>1 );
  }
  /**
   * @param args
//   */
//  public static void main(String[] args) {
//    // TODO Auto-generated method stub
//
//    List<_0_AarraySortTest> li = new ArrayList<_0_AarraySortTest>();
//    li.add(new _0_AarraySortTest(1, null));
//    li.add(new _0_AarraySortTest(2, "dfsd"));
//    li.add(new _0_AarraySortTest(3, null));
//    li.add(new _0_AarraySortTest(4, "ying"));
//
//    Collections.sort(li, new Comparator<_0_AarraySortTest>() {
//
//      @Override
//      public int compare(_0_AarraySortTest o1, _0_AarraySortTest o2) {
//        // TODO Auto-generated method stub
//        if (o1.com == o2.com)
//          return 0;
//        else if (o1.com == null)
//          return 1;
//        else if (o2.com == null)
//          return -1;
//        else
//          return o1.com.compareTo(o2.com);
//      }
//
//    });
//
////    List中含有4个元素，根据合并排序的算法，首先分为[0:2) 和[2:4)
////    接着[0,2)分为[0:1) 和[1:2)
////[0:1):TestCompare [com=null, id=1]
////[1:2):TestCompare [com=dfsd, id=2]
////    合并排序后为
////    TestCompare [com=dfsd, id=2]
////    TestCompare [com=null, id=1]
////    接着执行[2:4),分为[2:3) 和[3:4)
////[2:3):TestCompare [com=null, id=3]
////[3:4):TestCompare [com=ying, id=4]
////    合并排序后为：
////    TestCompare [com=ying, id=4]
////    TestCompare [com=null, id=3]
////
////    将两组合并的数据进行再次合并，及为：
////    TestCompare [com=dfsd, id=2]
////    TestCompare [com=ying, id=4]
////    TestCompare [com=null, id=1]
////    TestCompare [com=null, id=3]
//
//
//  }
}
