package prev;

import java.util.Arrays;

public class Test2511 {
    public static int captureForts(int[] forts) {
        if (forts.length == 1) {
            return 0;
        }
        int[] leftNearestVacant = new int[forts.length];
//        for(int i = 0; i < leftNearestVacant.length; i++){
//            leftNearestVacant[i] = i-1;
//        }
        Arrays.fill(leftNearestVacant, -1);
        for (int i = 1; i < forts.length; i++) {
            if (forts[i - 1] == -1) {
                leftNearestVacant[i] = i - 1;
            } else {
                leftNearestVacant[i] = leftNearestVacant[i - 1];
            }
        }
        int[] rightNearestVacant = new int[forts.length];
//        for(int i = 0; i < rightNearestVacant.length; i++){
//            rightNearestVacant[i] = i+1;
//        }
        Arrays.fill(rightNearestVacant, -1);
        for (int i = forts.length - 2; i >= 0; i--) {
            if (forts[i + 1] == -1) {
                rightNearestVacant[i] = i + 1;
            } else {
                rightNearestVacant[i] = rightNearestVacant[i + 1];
            }
        }

        int res = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {

                int maxDiff = Math.max(rightNearestVacant[i] == -1 ? 0 : rightNearestVacant[i] - i - 1, leftNearestVacant[i] == -1 ? 0 : i - leftNearestVacant[i] - 1);
                res = Math.max(res, maxDiff);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int res = captureForts(new int[]{1,-1,-1,1,1});
        System.out.println(res);
    }
}
