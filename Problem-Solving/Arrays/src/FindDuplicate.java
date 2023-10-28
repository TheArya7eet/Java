public class FindDuplicate{
    private static int findDuplicate(int[] arr){
        // Declare two pointers - slow and fast, both initialised with the first element of the arr
        int slow = arr[0], fast = arr[0];

        do{
            // Move the slow pointer by 1
            slow = arr[slow];
            // Move the fast pointer by 2
            fast = arr[arr[fast]];
        } while( slow != fast);

        // Move the fast pointer to the first position, i.e. the 0th index
        fast = arr[0];
        // Until slow is not equal to fast, move both of the pointers by 1 
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        System.out.println("Duplicate element is: " + findDuplicate(new int[] {2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }
}