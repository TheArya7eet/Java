import java.util.Arrays;

public class ReverseString {
    private static void reverseString(char[] str){
        int n = str.length;

        for(int i = 0; i < n / 2; i++){
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
