public class SwapTwoNumbers {
    private static void swapXOR(int a, int b){
        a = a ^ b; // XOR a and b and store the result in a
        b = a ^ b; // XOR the result of step 1 with b and store the result in b
        a = a ^ b; // XOR the result of step 1 with the result of step 2 and store the result in a

        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        int a = 5, b = 6;

        swapXOR(a, b);
    }    
}
