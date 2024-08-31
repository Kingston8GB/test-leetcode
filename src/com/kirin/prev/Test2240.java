package prev;

public class Test2240 {
    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for(int i = 0; i < total / cost1 + 1; i++){
            for(int j = 0; i < total / cost2 + 1; i++){
                if(cost1 * i + cost2 * j <= total){
                    res++;
                }else{
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(waysToBuyPensPencils(20,10,5));
    }
}
