import java.util.Arrays;

public class ReverseString {
    private static void reverseString(char[] str){
        int n = str.length;

        // Run a loop i ranging from 0 to (n/2 - 1)
        for(int i = 0; i < n / 2; i++){
            // Reverse the string by swapping the characters
            char temp = str[i];
            str[i] = str[n - 1 - i];
            str[n - 1 - i] = temp; 
        }
    }

    public static void main(String[] args) {
        char[] str = {'h', 'e', 'l', 'l', 'o'};

        reverseString(str);

        System.out.println(Arrays.toString(str));
    }
}
