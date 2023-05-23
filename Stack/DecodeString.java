/*
 * DECODE A STRING
 * 
 * We have an encoded strings and the task is to decode it.
 * The pattern in which the strings are encoded is as follows:
 * 
 * Sample Input 1: 2[cv]
 * Sample Output 1: cvcv
 * 
 * Sample Input 2: 3[b2[v]]L
 * Sample Output 2: bvvbvvbvvL
 * 
 * Approach -
 * - take two stack , one for number and another for string.
 * - two variable num and currStr to store current values.
 * - for whole length of input string s:
 *      if(character c at i)==number => num=num*10+c-'0'
 *      else if(character c at i)==letter => currStr.append(c)
 *      else if(charcter c at i)=='[' => nums.push(num)
 *                                       strs.push(currStr)
 *                                       num=0;
 *                                       currStr=""
 *      else(charcter at i)==']' => int prevNum=nums.pop()
 *                                  String prevStr=strs.pop()
 *                                  currstr=prevStr+(currStr , prevNum of times)
 * -return currStr;
 */

package Stack;

import java.util.*;

public class DecodeString {

    public static String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        int num = 0;
        StringBuilder currStr = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // the expression num = num * 10 + c - '0' allows us to construct a number from a sequence of digits.
                num = num * 10 + c - '0';
            } else if (Character.isLetter(c)) {
                currStr.append(c);
            } else if (c == '[') {
                nums.push(num);
                strs.push(currStr.toString());
                num = 0;
                currStr = new StringBuilder();
            } else { // c==']'
                int prevNum = nums.pop();
                String prevStr = strs.pop();
                currStr = new StringBuilder(prevStr).append(currStr.toString().repeat(prevNum));
            }
        }

        return currStr.toString();
    }

    public static void main(String[] args) {
        String s = "3[b2[v]]L";
        System.out.println(decodeString(s));
    }
}
