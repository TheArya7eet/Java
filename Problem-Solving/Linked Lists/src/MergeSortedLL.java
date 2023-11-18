public class MergeSortedLL {
    private static void display(Node head) {
        // Create a temp node set to the head of LL
        Node temp = head;

        // Until temp is NULL
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Approach 1 - By creating a new LL
    private static void mergeTwoLists1(Node l1, Node l2){
        // Create a dummy node containing the value 0
        Node dummy = new Node(0);
        // Create a temp node set to dummy 
        Node temp = dummy;

        // Until either of l1 or l2 reaches null
        while(l1 != null && l2 != null){
            // If l1 node value is less than or equal to that of l2
            if(l1.value <= l2.value) {
                // Point the next of temp to l1
                temp.next = l1;
                // Advance l1 to its next node
                l1 = l1.next;
            }
            // Else
            else{
                // Point the next of temp to l2
                temp.next = l2;
                // Advance l2 to its next node
                l2 = l2.next;
            }

            // Advance temp to its next node
            temp = temp.next;
        }

        // Add if any remaining nodes of l1 are present
        while(l1 != null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        // Add if any remaining nodes of l2 are present
          while(l2 != null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;

        }

        display(dummy.next);
    }

    // Approach 2 - In place
    private static void mergeTwoLists2(Node l1, Node l2){
        // When l1 is empty then our output will be same as l2
        if(l1 == null) display(l2); 

        // When l2 is empty then our output will be same as l1
        if(l2 == null) display(l1);
        
        // If l1 node value is greater than l2 node value, swap l1 and l2
        if(l1.value > l2.value) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        // Create a result node set to l1
        Node result = l1;

        // Until either of l1 or l2 reaches null
        while(l1 != null && l2 != null){
            // Create a temp node set to null
            Node temp1 = null;

            // Until l1 reaches null or l1 node value becomes greaeter than that of l2
            while(l1 != null && l1.value <= l2.value){
                // Update temp to l1
                temp1 = l1;
                // Advance l1 to its next node
                l1 = l1.next;
            }

            // Once the above iteration is complete, update temp.next to l2
            temp1.next = l2;

            // Swap l1 and l2
            Node temp2 = l1;
            l1 = l2;
            l2 = temp2;
        }

        display(result);
    }
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);

        display(l1);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        mergeTwoLists2(l1, l2);
    }
}