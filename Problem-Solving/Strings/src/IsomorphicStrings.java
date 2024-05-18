
import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings{

    // Using two HashMaps
    private static boolean isIsomorphic1(String a, String b){
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        boolean flag = true;

        // Put the characters of the respective strings as keys and ' ' as their corresponding values
        for(int i = 0; i < a.length(); i++){
            map1.put(a.charAt(i), ' ');
            map2.put(b.charAt(i), ' ');
        }

        // Traverse the first string
        for(int i = 0; i < a.length(); i++){
            // If the value is a blank space instead of a character, replace it with the ith character of the second string
            if(map1.get(a.charAt(i)) == ' '){
                map1.put(a.charAt(i),b.charAt(i));
            }
            // Else if the value is not a blank space (the character has occurred for more than once in the string) i.e. check if the value is equal to the ith character of the second string
            else if(map1.get(a.charAt(i)) != b.charAt(i)){
                // If not equal, it means the strings are not isomorphic
                flag = false;
                break;
            }
        }

        // Traverse the second string and repeat the above steps
        for(int i = 0; i < a.length(); i++){
            if(map2.get(b.charAt(i)) == ' '){
                map2.put(b.charAt(i),a.charAt(i));
            }
            else if(map2.get(b.charAt(i)) != a.charAt(i)){
                flag = false;
                break;
            }
        }

        return flag;
    }


    // Using HashMap and HashSet
    private static boolean isIsomorphic2(String a, String b){
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < a.length(); i++){
            // If the HashMap already contains the key i.e. the ith character of a
            if(map.containsKey(a.charAt(i))){
                // Store the value of the ith charcter of a (in the map) in a temp character
                Character temp = map.get(a.charAt(i));
                // Check 
                // If temp is equal to the ith character of  b
                if(temp == b.charAt(i)) continue;
                // Else, 
                else return false;
            }
            else{
                map.put(a.charAt(i), b.charAt(i));
                if(set.contains(b.charAt(i))) return false;
                else set.add(b.charAt(i));
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.print(isIsomorphic1("egg", "add"));
    }
}