package prev;

import java.util.Arrays;

public class Test1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // 记录最少的那个阈值距离内的邻居数量，以及该节点的下标（仅此题）
        int[] res = new int[]{Integer.MAX_VALUE / 2, -1};

        // 初始化邻接矩阵
        int[][] adjMatrix = new int[n][n];
        for(int[] row : adjMatrix){
            Arrays.fill(row,Integer.MAX_VALUE / 2);
        }
        for(int[] edge : edges){
            adjMatrix[edge[0]][edge[1]] = edge[2];
            adjMatrix[edge[1]][edge[0]] = edge[2];
        }

        // O(n^3)复杂度更新邻接矩阵
        for(int k = 0; k < n; k++){
            adjMatrix[k][k] = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }

        // 遍历邻接矩阵，找到小于distanceThreshold的所有位置
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(adjMatrix[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= res[0]){
                res[0] = cnt;
                res[1] = i;
            }
        }
        return res[1];
    }

    public static void main(String[] args) {
        Test1334 test1334 = new Test1334();
        int[][] edges = {{0,1,2}, {0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};

        int res = test1334.findTheCity(5, edges, 2);
        System.out.println("res = " + res);

    }
}
