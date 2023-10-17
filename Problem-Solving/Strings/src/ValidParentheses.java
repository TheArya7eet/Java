import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    private static boolean isValid(String str){
        HashMap<Character, Character> map = new HashMap<>();

        // Store the closing brackets as keys and their respective opening brackets as their values
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            // If the current character (bracket) is one of the opening brackets
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                // Push the character to the stack
                stk.push(str.charAt(i));
            }
            // Else
            else{
                // If the stack is not empty and the top element of the stack = opening bracket of the current closing bracket
                if(!stk.isEmpty() && stk.peek() == map.get(str.charAt(i))){
                // Pop out the character from the stack
                stk.pop();
                }
                // Else , that means the opening bracket does not have a closing bracket of its type or not in order
                else{
                    // Hence, invalid parantheses
                    return false;
                }
            }
        }

        // After traversing the string, if the stack is empty
        if(stk.size() == 0) return true;

        return false;
    }

    public static void main(String[] args) {
        String str = "(){}[]";

        System.out.println(isValid(str));
    }
}
