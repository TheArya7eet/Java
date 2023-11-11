public class DeleteNodeFromLL {
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

    private static void deleteNode(Node head, int target){
        if(head == null) return;
        
        // Create a temp node set to head
        Node temp = head;
        // Until the value of temp is equal to the given target, advance temp to its next node
        while(temp.value != target) temp = temp.next;
        
        // If the temp.next is null, i.e. temp is the tail
        if(temp.next == null){
            // Create a temp2 node set to head
            Node temp2 = head;
            // Until we reach the second last node, we advance temp2 to its next node
            while(temp2.next.next != null) temp2 = temp2.next;

            // Set temp.next to null
            temp2.next = null; 
            return;
        }

        // Update the value of temp with the value of temp.next
        temp.value = temp.next.value;
        // Set temp.next to temp.next.next
        temp.next = temp.next.next;
    }    

    public static void main(String[] args) {
        Node head = new Node(1);
        head.insertLast(head, 2);
        head.insertLast(head, 3);
        head.insertLast(head, 4);

        deleteNode(head, 4);

        display(head);
    }
}
