package prev;

public class TestJZ44 {
    public static int findNthDigit(int n) {
        if(n<10){
            return n;
        }
        int left = 10;
        int right = 10 + 90 * 2;
        int cnt = 2;
        while(true){
            if(n >= left && n < right){
                int num = (n-left) / cnt + (int)Math.pow(10,cnt-1);
                int digit = (n-left) % cnt;
                return String.valueOf(num).charAt(digit) - '0';
            }
            cnt++;
            left = right;
            right += (int) Math.pow(10,cnt-1) * cnt * 9;
        }
        // if(n >= 10 && n < 10+90*2){
        //     int num = (n-10) / 2 + 10;
        //     int digit = (n-10) % 2;
        //     return String.valueOf(num).charAt(digit) - '0';
        // }else if(n >= 10+90*2 && n < 10+90*2+900*3){
        //     int num = (n-(10+90*2)) / 3 + 100;
        //     int digit = (n-(10+90*2)) % 3;
        //     return String.valueOf(num).charAt(digit) - '0';
        // }
        // return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(10000000));
    }
}
