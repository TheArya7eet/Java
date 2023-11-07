public class RemoveKthNodeFromEnd {
    private static void display(Node head) {
        // Create a temporary node set to the head of LL
        Node temp1 = head, temp2 = head;

        // Until temp is null
        while (temp1 != null) {
            System.out.print(temp1.value + " -> ");
            temp1 = temp1.next;
        }

        System.out.println("null");
    }

    // Two-pointer approach
    private static void remove(Node head, int k){
        // Create a dummy node
        Node dummy = new  Node(0);
        // Point dummy.next to head
        dummy.next = head;

        // Initialise two pointers - fast and slow, both set to dummy
        Node slow = dummy, fast = dummy;

        // Start traversing until the fast pointer reaches the kth node
        for(int i = 1; i <= k; i++){
            // Advance fast pointer to its next node
            fast = fast.next;
        }

        //  Start traversing by advancing both the pointers by one step until the fast pointer reaches the last node
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // Point the slow.next to slow.next.next
        slow.next = slow.next.next;

        display(dummy.next);
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.insertLast(head, 2);
        head.insertLast(head, 3);
        head.insertLast(head, 4);
        head.insertLast(head, 5);
        head.insertLast(head, 6);

        remove(head, 1);
    }
}
