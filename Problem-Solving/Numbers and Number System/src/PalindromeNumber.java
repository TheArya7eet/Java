public class PalindromeNumber {
    private static boolean isPalindrome(int num){
        // If num is negative, return false
        if(num < 0) return false;

        // Store the value of num in a temporary variable
        int temp = num;
        int rev = 0;

        // Reverse temp
        while(temp != 0){
            int lastDIg = temp % 10;
            rev = rev * 10 + lastDIg;
            temp = temp / 10;
        }

        // If the reversed number is equal to num, the given number is palindrome
        if(rev == num) return true;

        // Else, return false
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    
}
