public class MinimumBitFlips {
    private static int minBitFlips(int start, int goal){
        int ans = start ^ goal; // XOR the start with the goal
        
        // The set bits in the ans variable represent the indices of the start variable in which the bits need to be flipped

        // Initialise a count variable which will store the minimum number of bit flips
        int count = 0;

        // Check for the set bits in the ans variable
        for(int i = 0; i < 31; i++){
            // Whenever the ith bit is a set bit, incremenet count
            if((ans & (1 << i)) != 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
    }
}
