public class IthBitSetOrNot {
    private static boolean checkSetLeftShift(int num, int i){
        if((num & (1 << i)) != 0) return true;
        return false;
    }

    private static boolean checkSetRightShift(int num, int i){
        if(((num >> i) & 1) != 0) return true;
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(checkSetLeftShift(13, 2));
        System.out.println(checkSetRightShift(13, 1));

    }
}
