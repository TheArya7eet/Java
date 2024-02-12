public class DetectCycleInLL {
    private static boolean hasCycle2(Node head) {
        if (head == null)
            return false;
        
        // Declare two pointers - fast and slow, both set to head
        Node fast = head;
        Node slow = head;
        
        // Until fast.next reaches null or fast.next.next reaches null
        while (fast.next != null && fast.next.next != null) {
            // Move fast pointer by two nodes
            fast = fast.next.next;
            // Move slow pointer by one node
            slow = slow.next;

            // If fast and slow point to the same node
            if (fast == slow)
                // Loop is present
                return true;
        }

        // If we come out of the loop, there is no loop
        return false;
    }

    public static void main(String[] args) {

    }
}
