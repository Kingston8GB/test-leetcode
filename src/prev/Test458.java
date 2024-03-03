package prev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test458 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() > p.length()){
            return res;
        }
        char[] pCharArray = p.toCharArray();
        Arrays.sort(pCharArray);
        String pSorted = new String(pCharArray);

        int left = 0;
        int right = p.length();
        // Set<Character> set = new HashSet<>();
        // for(int i = left; i <= right; i++){
        //     set.add(s.charAt(i));
        // }
        // int curSize = set.size();
        // left++;
        // right++;
        while(right <= s.length()){
            String str = s.substring(left,right);
            char[] strCharArray = str.toCharArray();
            Arrays.sort(strCharArray);
            String strSorted = new String(strCharArray);
            if(strSorted.equals(pSorted)){
                res.add(left);
            }
            left++;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        for (Integer anagram : anagrams) {
            System.out.print(anagram + " ");
        }
    }
}
