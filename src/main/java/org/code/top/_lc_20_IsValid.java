package main.java.org.code.top;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * describe:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 * @author lixilong
 * @date 2019/01/23
 */
public class _lc_20_IsValid {

  public static void main(String[] args) {
    _lc_20_IsValid  isValid = new _lc_20_IsValid();
    isValid.test();
  }

  public void test(){
    String s = "()";

//    String s1 = "(()";
//    String s2 = "))";
//    String s3 = ")";
//    String s4 = "({[()]})";
    System.out.println(isValid(s));
  }

//方法2： map 字典表,key右v左

  public boolean isValid(String s) {
    Stack stack = new Stack();
    Map paren = new HashMap() {
      {
        put(')','(');
        put(']','[');
        put('}','{');
      }
    };

    char[] strArray = s.toCharArray();
    for (char ch : strArray) {
      if (paren.containsValue(ch))
        stack.push(ch);
      else if (paren.containsKey(ch)) {
        if (stack.isEmpty() || !paren.get(ch).equals(stack.pop())) {
          return false;
        }
      }
    }
    return stack.isEmpty() ? true : false;
  }

}
