public class ReverseLinkedList {
    private static void display(Node head) {
        // Create a temporary node set to the head of LL
        Node temp = head;

        // Until temp is null
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Approach 1 - Recursive
    private static void reverseLinkedList(Node head){
        // Create a dummy node initialised with null 
        Node dummy = null;

        // Until head is null
        while(head != null){
            // Create a next node set to head.next
            Node next = head.next;
            // Point the head.next to dummy node, i.e. null
            head.next = dummy;
            // Point the dummy to head node
            dummy = head;
            // Point the head to next node
            head = next;
        }

        display(dummy);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.insertLast(head, 2);
        head.insertLast(head, 3);

        reverseLinkedList(head);
    }
}
