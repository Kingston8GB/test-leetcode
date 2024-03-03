package prev;

public class Test2596 {
    public static boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0){
            return false;
        }
        int[][] directions = new int[][]{{2,1},{2,-1},
                {1,2},{1,-2},
                {-1,2},{-1,-2},
                {-2,1},{-2,-1}};
        int cur = 0;
        int curI = 0;
        int curJ = 0;
        while(cur < grid.length * grid.length - 1){
            boolean flag = false;
            for(int[] direction : directions){
                if(curI + direction[0] < grid.length && curI + direction[0] >= 0 && curJ + direction[1] < grid[0].length && curJ + direction[1] >= 0){
                    if(grid[curI + direction[0]][curJ + direction[1]] == cur + 1){
                        cur++;
                        curI += direction[0];
                        curJ += direction[1];
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        System.out.println(checkValidGrid(grid));
    }
}
