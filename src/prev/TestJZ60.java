package prev;

public class TestJZ60 {
    public static double[] dicesProbability(int n) {
        double[] dpPre = new double[6+1];
        for(int i = 1; i <= 6; i++){
            dpPre[i] = 1.0 / 6;
        }
        double[] dpCur = dpPre;
        for(int i = 2; i <= n; i++){
            dpCur = new double[6 * i + 1];
            for(int j = 1; j <= 6*i; j++){
                for(int k = 1; k <= 6; k++){
                    System.out.println(dpCur[j]);
                    if((j-k) >=1 && (j-k) < dpPre.length){
                        dpCur[j] += dpPre[j - k] / 6;

                    }
                }

            }
            dpPre = dpCur;
        }
        double[] res = new double[6 * n - n + 1];
        if (dpCur.length - n >= 0) System.arraycopy(dpCur, n, res, 0, dpCur.length - n);
        return res;
    }

    public static void main(String[] args) {
        double[] res = dicesProbability(2);
        for (double prob : res) {
            System.out.print(prob + " ");
        }
    }
}
