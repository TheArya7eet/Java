public class SetTheIthBit {
    private static int setBit(int num, int i){
        return num | (1 << i);
    }
    public static void main(String[] args) {
        System.out.println(setBit(13, 1));
    }
}
