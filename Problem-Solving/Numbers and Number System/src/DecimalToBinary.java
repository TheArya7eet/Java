public class DecimalToBinary {
    private static String reverse(String s){
        char[] arr = s.toCharArray();
        
        int left = 0, right = arr.length - 1;

        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        s = new String(arr);
        return s;
    }

    private static String toBinary(int decNum){
        String binNum = "";

        while(decNum > 0){
            if(decNum % 2 == 1) binNum += '1';
            else binNum += '0';
            decNum /= 2;
        }
        
        binNum = reverse(binNum);
        return binNum;
    }   

    public static void main(String[] args) {
        System.out.println(toBinary(13));
    }    
}
