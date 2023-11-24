public class MiddleOfLL {
    // Approach 1
    private static Node middle1(Node head){
        // Initialise the size of the LL with 0
        int size = 0;

        Node temp1 = head;
        // Traverse to find the size of the LL
        while(temp1 != null){
            size++;
            temp1 = temp1.next;
        }

        Node temp2 = head;
        // Now traverse again till size / 2, and we will get our middle node
        for(int i = 1; i <= size / 2; i++){
            temp2 = temp2.next;
        }

        return temp2;
    }

    // Approach 2 - Tortoise-Hare Method
    private static Node middle2(Node head){
        // Create two nodes both set to the head
        Node slow = head, fast = head;

        // Until the fast pointer and fast.next  is null, move the slow and fast pointers by one step and two steps respectively
        while(fast != null && fast.next != null){
            // Advance the slow to its next node
            slow = slow.next;
            // Advance the fast to the next of its next node
            fast = fast.next.next;
        }

        // After the loop ends, the slow pointer is our middle node
        return slow;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.insertLast(head, 3);
        head.insertLast(head, 4);
        head.insertLast(head, 7);
        head.insertLast(head, 5);
        head.insertLast(head, 6);
        head.insertLast(head, 8);

        Node middle1 = middle1(head);
        Node middle2 = middle2(head);
        
        System.out.println(middle1.value);
        System.out.println(middle2.value);
    }
}
