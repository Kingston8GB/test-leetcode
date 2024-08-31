package prev;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder remainString = new StringBuilder();
        int cursor = 0;
        char lastAddChar = 'z';
        int lastAddCharCount = 0;

        for(int i = 1; i >= 0; i--) {
            char c = (char)('a' + i);
            if(map.containsKey(c)) {
                int value = map.get(c);
                for(int j = 0; j < value && j < repeatLimit; j++) {
                    sb.append(c);
                    if(!remainString.toString().isEmpty()) {
                        for(int k = 0; cursor < remainString.length() && k < repeatLimit; k++) {
                            char temp = remainString.charAt(cursor);
                            sb.append(temp);
                            lastAddChar = temp;
                            cursor++;
                            lastAddCharCount = 0;
                            lastAddCharCount++;
                        }
                    }
                }
                if(value > repeatLimit) {
                    for(int k = 0; k < (value - repeatLimit); k++) {
                        remainString.append(c);
                    }
                }
            }
        }

        if(!remainString.toString().isEmpty()) {
            for(int k = 0; cursor < remainString.length() && k < repeatLimit; k++) {

                char temp = remainString.charAt(cursor);
                if(lastAddChar == temp && k >= (repeatLimit - lastAddCharCount)) {
                    break;
                }
                sb.append(temp);
                cursor++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        String s = test1.repeatLimitedString("aababab", 2);
        System.out.println(s);
    }
}
