public class ArmstrongNumber {
    // Count the number of digits in a number
    private static int countDig(int num){
        int count = 0;

        while(num != 0){
            num /= 10;
            count++;
        }

        return count;
    }

    private static boolean isArmstrong(int num){
        // Declare a variable to store the number of digits
        int digits = countDig(num);
        int sum = 0;

        int temp = num;

        // Calculate the sum of digits raised to the power of (number of digits)
        while(temp != 0){
            int lastDig = num % 10;
            sum += Math.pow(lastDig, digits);
            temp /= 10;
        }

        // If sum of the digits raised to the power of (number of digits) = the given number, then the number is an Armstrong number
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(2));
    }
}
