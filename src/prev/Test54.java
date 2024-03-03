package prev;

import java.util.ArrayList;
import java.util.List;

public class Test54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int round = 1;
        int i = 0;
        int j = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = 0;
        while(cnt < m * n - 1){
            for(; j < n - round && cnt < m * n; j++){
                res.add(matrix[i][j]);
                cnt++;
            }
            for(; i < m - round && cnt < m * n; i++){
                res.add(matrix[i][j]);
                cnt++;
            }
            for(; j >= round && cnt < m * n; j--){
                res.add(matrix[i][j]);
                cnt++;
            }
            for(; i >= round && cnt < m * n; i--){
                res.add(matrix[i][j]);
                cnt++;
            }
            j = round;
            i = round;
            round++;
        }
        if(cnt == m * n - 1){
            res.add(matrix[m/2][n/2]);
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] matrix ;
//        matrix = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        matrix = new int[][]{{6,9,7}};
        List<Integer> res = spiralOrder(matrix);
        for (Integer re : res) {
            System.out.print(res + " ");
        }
    }
}
