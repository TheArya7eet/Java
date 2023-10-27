import java.util.Arrays;

public class ValidAnagram {
    private static boolean isAnagram(String s, String t) {
        // If the lengths of both the strings are not equal,
        if (s.length() != t.length()) {
            return false;
        }

        // Convert the strings to character arrays
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        // Sort the arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Traverse one of the arrays
        for(int i = 0; i < arr1.length; i++){
            // At any point, if the current character of arr1 != the current character of arr2
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

}
