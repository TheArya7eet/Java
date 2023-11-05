public class AddTwoNumbers {
    public static void display(Node head) {
        // Create a temporary node which will point to the same object that head is
        // pointing
        Node temp = head;

        // Until temp is null
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    private static void addtTwoNumbers(Node l1, Node l2){
        // Create a dummy node containing the value 0
        Node dummy = new Node(0);
        // Create a temp node pointing to dummy
        Node temp = dummy;
        int carry = 0;

        // If l1 is not null OR l2 is not null OR carry is 1
        while(l1 != null || l2 != null || carry == 1){
            int sum = 0;

            // If l1 is not null
            if(l1 != null){
                // Add the value of l1 node to sum
                sum += l1.value;
                // Point l1 to its next node
                l1 = l1.next;
            }

            // If l2 is not null
            if(l2 != null){
                // Add the value of l2 node to sum
                sum += l2.value;
                // Point l2 to its next node
                l2 = l2.next;
            }

            // Add the value of carry to sum
            sum += carry;
            // Update value of carry
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
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
