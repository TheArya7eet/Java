public class AddTwoNumbers {
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

    private static void addtTwoNumbers(Node l1, Node l2){
        // Create a dummy node containing the value 0
        Node dummy = new Node(0);
        // Create a temp node set to dummy
        Node temp = dummy;
        int carry = 0;

        // Until l1 is null OR l2 is not null OR carry is 1
        while(l1 != null || l2 != null || carry == 1){
            int sum = 0;

            // If l1 is not null
            if(l1 != null){
                // Add the value of l1 node to sum
                sum += l1.value;
                // Advance l1 to its next node
                l1 = l1.next;
            }

            // If l2 is not null
            if(l2 != null){
                // Add the value of l2 node to sum
                sum += l2.value;
                // Advance l2 to its next node
                l2 = l2.next;
            }

            // Add the value of carry to sum
            sum += carry;
            // Update value of carry
            carry = sum / 10;
            // Create a node containing the digit value of (sum % 10) and set it to temp node's next
            Node node = new Node(sum % 10);
            temp.next = node;
            // Advance temp node to its next node
            temp = temp.next;
        }

        display(dummy.next);
    }

    public static void main(String[] args) {
      
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

       addtTwoNumbers(l1, l2);
    }
    
}
