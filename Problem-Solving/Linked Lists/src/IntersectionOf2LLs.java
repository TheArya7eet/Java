public class IntersectionOf2LLs {
    // Approach 1
    private static int getDifference(Node headA, Node headB){
        Node temp1 = headA;
        Node temp2 = headB;

        int sizeA = 0, sizeB = 0;
        while(temp1 != null){
            temp1 = temp1.next;
            sizeA++;
        }
        while(temp2 != null){
            temp2 = temp2.next;
            sizeB++;
        }

        return sizeA - sizeB; // If difference is negative, length of list 2 > length of list 1 else vice-versa
    }

    private static Node getIntersectionionNode1(Node headA, Node headB){
        // Difference between lengths of the two lists
        int diff = getDifference(headA, headB);

        if(diff < 0){
            // list 2 is greater in length, hence advance headB to its next node until diff is 0
            while(diff++ != 0) {
                headB = headB.next;
            }
        }
        else{
            // list 1 is greater in length, hence advance headA to its next node until diff is 0
            while(diff-- != 0){
                headA = headA.next;
            }
        }
        // Now advance both headA and headB to their next nodes
        while(headA != null){
            // If headA and headB collide, we have found our intersection node
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }  

        // If the above loop ends without returning anything, i.e. there is no intersection node
        return null;
    }

    // Approach 2
    private static Node getIntersectionNode2(Node headA, Node headB){
        // Take two dummy nodes, set to headA and headB
        Node d1 = headA, d2 = headB;

        // Until d1 and d2 point to the same node
        while(d1 != d2){
            // If d1 reaches null, set it to headB 
            // Else, advance d1 to its next node
            d1 = d1 == null? headB:d1.next;
            // If d2 reaches null, set it to headA
            // Else, advance d2 to its next node
            d2 = d2 == null? headA:d2.next;
        }

        // Return d1 or d2
        return d1;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.insertLast(head1, 3);
        head1.insertLast(head1, 1);
        head1.insertLast(head1, 2);
        head1.insertLast(head1, 4);
        
        Node headA = head1;
        head1 = head1.next.next;
        
        Node head2 = new Node(3);

        Node headB = head2;
        head2.next = head1;

        headA.display(headA);
        headB.display(headB);

        Node ans = getIntersectionNode2(headA, headB);

        if(ans != null){
            System.out.println("Intersection node is: " + ans.value);
        }
        else{
            System.out.println("Intersection node is: " + null);
        }
    }
}
