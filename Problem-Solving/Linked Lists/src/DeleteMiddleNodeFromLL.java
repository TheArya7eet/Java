public class DeleteMiddleNodeFromLL {
    private static void display(Node head) {
        // Create a temporary node set to the head of LL
        Node temp1 = head;

        // Until temp is null
        while (temp1 != null) {
            System.out.print(temp1.value + " -> ");
            temp1 = temp1.next;
        }

        System.out.println("null");
    }

    private static void DeleteMiddleNode(Node head){
        // If there is only one node, i.e. head.next = null
        if(head.next != null){
            System.out.println("null");;
        }

        // Create two node pointers - slow and fast, both initialised with head
        Node slow = head, fast = head;
        // Create a temp node set to head
        Node temp = head;
        
        // Until fast AND fast.next don't reach null
        while(fast.next != null && fast.next != null){
            // Update temp to slow
            temp = slow;

            // Move the slow and fast pointers by one step and two steps respectively
            // Advance the slow to its next node
            slow = slow.next;
            // Advance the fast to the next of its next node
            fast = fast.next.next;
        }

        // After the loop ends, slow pointer will be the middle node of the LL
        // And temp node will be the previous node of the middle node
        // To delete the middle node, set temp.next to slow.next
        temp.next = slow.next;

        display(head);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.insertLast(head, 3);
        head.insertLast(head, 4);
        head.insertLast(head, 7);
        head.insertLast(head, 5);
        head.insertLast(head, 6);
        head.insertLast(head, 8);

        DeleteMiddleNode(head);
    }
}
