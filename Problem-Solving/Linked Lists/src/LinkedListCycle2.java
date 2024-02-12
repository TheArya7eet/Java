import java.util.HashSet;

public class LinkedListCycle2 {
    // Approach 1 - Hashing
    private static Node detectCycle(Node head) {
        // Create a HashSet to store the nodes
        HashSet<Node> set = new HashSet<>();

        Node temp = head;

        // Until temp reaches null
        while (temp != null) {
            // If set contains the node temp already, there is a loop in the LL
            if (set.contains(temp))
                return temp;

            // Add the current temp node to set and advance to the next node
            set.add(temp);
            temp = temp.next;
        }

        // If we come out of the loop, there is no loop in the LL
        return null;
    }

    // Approach 2 - Tortoise-Hare Method
    private static Node detectCycle2(Node head) {
        // If head is null or head.next is null
        if(head != null && head.next != null) return null;

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
            if (fast == slow){
                // Set slow to head
                slow = head;
                
                // Until slow and fast point to the same node again
                while(slow != fast){
                    // Advance both slow and fast by one node
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
