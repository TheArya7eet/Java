public class BinaryToDecimal {
    private static int toDecimal(int binNum){
        int dec = 0;
        
        int temp = binNum, digits = 0;
        while(temp != 0){
            temp /= 10;
            digits++;
        }

        for(int i = 0; i < digits; i++){
            dec += binNum % 10 * Math.pow(2, i);
            binNum /= 10;
        }
        
        return dec;
    }
    
    public static void main(String[] args) {
        System.out.println(toDecimal(110100));
    }
}
