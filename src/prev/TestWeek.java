package prev;

public class TestWeek {
    public static int minimumSum(int n, int k) {
        int numCnt = 0;
        int res = 0;

        for(int i = 1; i <= k /2 && numCnt < n; i++){
            res += i;
            numCnt++;
        }
        int restCnt = n- numCnt;

        for(int i = k; i < k + restCnt; k++){
            res += i;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 4;
        System.out.println(minimumSum(n,k));
    }
}
