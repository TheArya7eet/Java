public class Node {
    public int value; // Data stored in the node
    public Node next; // Reference to the next node

    // Constructor with only the value (next pointer set to null)
    public Node(int value) {
        this.value = value;
        this.next = null; // Initiallise the next reference to null
    }

    // Constructor with both data and next pointer
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    // Insertion at head
    public void insertFirst(Node head, int value) {
        // Declare the node with value
        Node node = new Node(value);
        // Reference the next of the node to head
        node.next = head;
        // Update the value of head to the value of node
        head = node;
    }

    // Insertion at tail
    public void insertLast(Node head, int value) {
        // Create the node containing the given value
        Node node = new Node(value);

        // If the LL is empty,
        if (head == null) {
            head = node;
            return;
        }

        // Traverse till the last node of the LL
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
    }

    // Insertion at a given index
    public void Insert(Node head, int value, int index) {
        // If the given index = 0, that means we have to insert at the head
        if (index == 0) {
            // Insert at first
            // Declare the node with value
            Node node = new Node(value);
            // Reference the next of the node to head
            node.next = head;
            // Update the value of head to the value of node
            head = node;
            return;
        }

        // Create a temporary node which will initially point to the head of the LL
        Node temp = head;

        // Run a loop i ranging from 1 to (index - 1)
        for (int i = 1; i < index; i++) {
            // Update the value of temp to temp.next until the loop ends
            temp = temp.next;
        }
        // After the loop ends, we will get the node after which the new node will be
        // inserted

        // Declare a node containing the given value and reference to the node next to
        // the temp node
        Node node = new Node(value, temp.next);
        // Update the value of temp.next to node
        temp.next = node;
    }

    // Display the LL
    public void display(Node head) {
        // Create a temporary node which will point to the same object that head is
        // pointing
        Node temp = head;

        // Until temp is null
        while (temp != null) {
            // Print the current node value
            System.out.print(temp.value + " -> ");
            // Advance temp to its next node
            temp = temp.next;
        }

        System.out.println("null");
    }
}

    
