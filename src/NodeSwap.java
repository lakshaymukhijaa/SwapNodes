/**
 * This class contains Functions to Swap Nodes in pairs by pointing to head and next nodes
 */
public class NodeSwap {

    /**
     * This function is used to swap list nodes in pairs
     * @param head- This points to head of the node
     * @return- Swapped Nodes in pairs
     */
    private static ListNode swapPairs(ListNode head) {
        // Creating A Dummy node
        ListNode dummy = new ListNode(0);
        // Point the next of dummy node to the head
        dummy.next = head;
        // This node will be used to traverse the list
        ListNode current = dummy;
        // Looping until we reach to the second last node
        while (current.next != null && current.next.next != null) {
            // First node of the pair
            ListNode first = current.next;
            // Second node of the pair
            ListNode second = current.next.next;
            // Point the next of first node to the node after second node
            first.next = second.next;
            // Now the current node's next should be the second node
            current.next = second;
            // Linking the original second node to the first node
            current.next.next = first;
            // Move the pointer two nodes ahead
            current = current.next.next;
        }
        return dummy.next;
    }

    /**
     * This Function is used to print the current nodes
     * @param head-This points to head of the node
     */
    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * This is main block
     * we will call ListNode Function and pass values to it
     * Then we will swap node in pairs using swapPairs() Function and then print it with printList() function
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        printList(swapPairs(head));

        printList(swapPairs(null));

        head = new ListNode(1);
        printList(swapPairs(head));
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}