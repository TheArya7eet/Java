public class NumberOfSetBits {
    private static int numberOfSetBits(int num){
        int count = 0;
        for(int i = 0; i < 31; i++){
            if((num >> i & 1) != 0) count++;
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfSetBits(13));
    }
}
