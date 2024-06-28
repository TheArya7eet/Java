public class FibonacciSum {
    public static int fibSum(int n){
        if(n <= 1){
            return 0;
        }
        
        int sum = 1;
        int first = 0, second = 1;
        while(n > 2){
            int third = first + second;
            first = second;
            second = third;
            sum += third;
            n--;
        }
        
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fibSum(5));
    }
}
