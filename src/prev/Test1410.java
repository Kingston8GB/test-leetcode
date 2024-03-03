package prev;

import java.util.HashMap;
import java.util.Map;

public class Test1410 {
    public String entityParser(String text) {
        // 方法一：投机取巧
        // text = text.replaceAll("&quot;","\"");
        // text = text.replaceAll("&apos;","\'");

        // text = text.replaceAll("&gt;",">");
        // text = text.replaceAll("&lt;","<");
        // text = text.replaceAll("&frasl;","/");
        // text = text.replaceAll("&amp;","&");
        // return text;

        // 方法二：哈希+双指针
        Map<String,Character> html2CharMap = new HashMap<>();
        html2CharMap.put("&quot;",'\"');
        html2CharMap.put("&apos;",'\'');
        html2CharMap.put("&gt;",'>');
        html2CharMap.put("&lt;",'<');
        html2CharMap.put("&frasl;",'/');
        html2CharMap.put("&amp;",'&');

        char[] textCharArray = text.toCharArray();
        int left = 0;
        int right = left;
        StringBuilder newText = new StringBuilder();
        while(left < textCharArray.length) {
            if(left != '&'){
                newText.append(textCharArray[left]);
            }else{
                right = left;
                StringBuilder temp = new StringBuilder();
                while(right < textCharArray.length && textCharArray[right] != ';' && (textCharArray[right] != '&' || (textCharArray[right] == '&' && right == left))) {
                    temp.append(textCharArray[right++]);
                }
                if(right == textCharArray.length) {
                    newText.append(temp.toString());
                    return newText.toString();
                }
                if(textCharArray[right] == ';'){
                    temp.append(';');
                    if(html2CharMap.containsKey(temp.toString())) {
                        newText.append(html2CharMap.get(temp.toString()));

                    }else{
                        newText.append(temp.toString());
                    }

                }else{
                    newText.append(temp.toString());
                }
                left = right;
            }
            left++;
        }
        return newText.toString();
    }

    public static void main(String[] args) {
        Test1410 test1410 = new Test1410();
        String s = test1410.entityParser("x &gt; y &amp;&amp; x &lt; y is always false");
        System.out.println("s = " + s);
    }
}
