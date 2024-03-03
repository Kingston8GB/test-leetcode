package test2024;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: Xiyao Li
 * Date: 2024/2/15 3:07
 */
public class Test394 {
    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        // Deque<Integer> bracketStack = new LinkedList<>();
        int leftBracketCount = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        Deque<String> stringStack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0) {
                int temp = 0;
                if(i > 0 && s.charAt(i-1) - '0' <= 9 && s.charAt(i-1) - '0' >= 0){
                    temp = numStack.pop() * 10;
                }
                numStack.push((s.charAt(i) - '0') + temp);
            } else if (s.charAt(i) == '[') {
                if(sb.length() > 0) {
                    stringStack.push(sb.toString());
                    sb = new StringBuilder();
                }

                leftBracketCount++;
            } else if (s.charAt(i) - 'a' <= 25 && s.charAt(i) - 'a' >= 0) {
                sb.append(s.charAt(i));
            } else {
                int temp = numStack.pop();
                StringBuilder sbTemp = new StringBuilder();
                for(int j = 0; j < temp; j++) {
                    sbTemp.append(sb.toString());
                }
                sb = new StringBuilder(sbTemp.toString());
                if(!stringStack.isEmpty()) {
                    String tempString = stringStack.pop();
                    sb = new StringBuilder(tempString + sbTemp.toString());
                }else{
                    res.append(sb);
                    sb = new StringBuilder();
                }
            }
        }
        res.append(sb);
        return res.toString();
    }

    public static void main(String[] args) {
        Test394 test394 = new Test394();
        System.out.println(test394.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
