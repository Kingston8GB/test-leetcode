package prev;

public class Test100152 {
    public int removeAlmostEqualCharacters(String word) {
        int res = 0;
        boolean prev = false;
        int i = 0;
        while(i < word.length()) {
            if(i == word.length() - 1) {
                return res;
            }
            // if(prev == true && )
            if(isAlmostEqualCharacters(word.charAt(i),word.charAt(i+1))) {
                res++;
                // prev = true;
                i+=2;
            }else{
                i++;
            }
        }
        return res;
    }

    public boolean isAlmostEqualCharacters(char a, char b) {
        return (a == b) || (a - b == 1) || (a - b == -1);
    }

    public static void main(String[] args) {
        Test100152 test100152 = new Test100152();
        System.out.println(test100152.removeAlmostEqualCharacters("dwefagrehgtrhggr"));
    }
}
