public class UniquePaths {
    // Approach 1 - Using recursion
    private static int countPaths1(int n, int m, int i, int j){
        // Base Case 1 -  When we have reached the right-bottom of the matrix
        if(i == (n - 1) && j == (m - 1)) return 1;

        // Base Case 1 - When you exceed n or m
        if(i > (n - 1) || j > (m - 1)) return 0;

        else return countPaths1(n, m, i + 1, j) + countPaths1(n, m, i, j + 1);
    }

    // Approach 2 - Using Combinatorics\
    private static int countPaths2(int n, int m){
        // Create a variable to store the number of steps for each path
        int steps = m + n - 2;
        
        // Create a variable to store either the number of steps in rightward direction or number or downward direction
        int r = m - 1;
       
        // Create a result variable to store the total number of paths to reach the end, initialised with 1
        double result = 1;
        
        for(int i = 1; i <= r; i++){
            result = result * (steps - r + i) / i;
        }

        return (int)result;
    }
    
    public static void main(String[] args) {
            System.out.println("Number  of ways to reach the right-bottom is: " + countPaths2(4, 4));
   } 
}
