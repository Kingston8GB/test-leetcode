package prev;

import java.util.ArrayList;
import java.util.List;

public class Test1222 {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        int[][] queensMatrix = sparse2Matrix(queens);


        for (int i = 0; i < 8; i++) {
            checkCertainDirection(i, king, queensMatrix);
        }

        return res;

    }

    public static int[][] sparse2Matrix(int[][] sparse) {
        int[][] matrix = new int[8][8];
        for (int[] edge : sparse) {
            matrix[edge[0]][edge[1]] = 1;
        }
        return matrix;
    }

    public static void checkCertainDirection(int directionNumber, int[] king, int[][] queensMatrix) {
        int newI = king[0];
        int newJ = king[1];

        while (newI >= 0 && newI < 8 && newJ >= 0 && newJ < 8) {
            if (newI != king[0]) {
                if (queensMatrix[newI][newJ] == 1) {
                    List<Integer> innerRes = new ArrayList<>();
                    innerRes.add(newI);
                    innerRes.add(newJ);
                    res.add(innerRes);
                    break;
                }
            }
            switch (directionNumber) {
                case 0 -> {
                    newI++;
                    newJ--;
                }
                case 1 -> {
                    newI++;
                    newJ++;
                }
                case 2 -> {
                    newI--;
                    newJ--;
                }
                case 3 -> {
                    newI--;
                    newJ++;
                }
                case 4 -> newI++;
                case 5 -> newJ++;
                case 6 -> newI--;
                case 7 -> newJ--;
                default -> {
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] kings = new int[]{0,0};
        List<List<Integer>> res = queensAttacktheKing(queens, kings);
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
