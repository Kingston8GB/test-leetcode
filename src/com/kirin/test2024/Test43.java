package test2024;

/**
 * Author: Xiyao Li
 * Date: 2024/2/12 1:35
 */
public class Test43 {
    public String multiply(String num1, String num2) {
        String res = "";
        for(int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder resOne = new StringBuilder(multiplyOne(num1, num2.charAt(i)));
            for(int j = 0; j < num2.length() - 1 - i; j++) {
                resOne.append("0");
            }
            res = add(res, resOne.toString());
        }
        return res;
    }

    private String multiplyOne(String num1, char num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1; i >= 0; i--) {
            int temp = (num1.charAt(i) - '0') * (num2 - '0') + carry;
            if(temp >= 10) {
                carry = temp / 10;
                temp %= 10;
            }else{
                carry = 0;
            }
            sb.append((char)('0' + temp));
        }
        if(carry > 0) {
            sb.append((char)('0' + carry));
        }
        sb.reverse();
        return sb.toString();
    }

    private String add(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder sb1 = new StringBuilder(num1);
        sb1.reverse();
        String num1Reverse = sb1.toString();
        StringBuilder sb2 = new StringBuilder(num2);
        sb2.reverse();
        String num2Reverse = sb2.toString();
        StringBuilder sb = new StringBuilder();

        int p = 0;
        int carry = 0;
        while(p < len1 && p < len2) {
            int temp = (num1Reverse.charAt(p) - '0') + (num2Reverse.charAt(p) - '0') + carry;
            if(temp >= 10) {
                carry = 1;
                temp %= 10;
            }else{
                carry = 0;
            }
            sb.append((char)('0' + temp));
            p++;
        }
        while(p < len1) {
            int temp = (num1Reverse.charAt(p) - '0') + carry;
            if(temp >= 10) {
                carry = 1;
                temp %= 10;
            }else{
                carry = 0;
            }
            sb.append((char)('0' + temp));
            p++;
        }
        while(p < len2) {
            int temp = (num2Reverse.charAt(p) - '0') + carry;
            if(temp >= 10) {
                carry = 1;
                temp %= 10;
            }else{
                carry = 0;
            }
            sb.append((char)('0' + temp));
            p++;
        }
        if(carry > 0) {
            sb.append("1");
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Test43 test43 = new Test43();
        System.out.println(test43.multiply("123456789", "987654321"));
    }
}
