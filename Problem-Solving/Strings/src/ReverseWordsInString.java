public class ReverseWordsInString {
    private static String reverseWords(String s){
        String ans = "";

        int n = s.length(), i = 0;

        while(i < n){
            String temp = "";

            while(s.charAt(i) == ' ' && i < n){
                i++;
            } 
            while(s.charAt(i) != ' ' && i < n){
                temp = temp + s.charAt(i);
            }
            if(temp.length() > 0){
                if(ans.length() == 0){ 
                    ans = temp;
                }
                ans = temp + " " + ans;
            } 
        }

        return ans;
    } 
}
