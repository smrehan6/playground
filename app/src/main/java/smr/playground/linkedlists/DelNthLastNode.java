package smr.playground.linkedlists;

/*
Delete nth node from last in singly linked list

Input - Head of linked list and n.
Output - new head

Example -
Input -> 1 2 3 4 5, n = 2
Output -> 1 2 3 5

Input -> 1 2 3 4 5, n = 1
Output -> 1 2 3 4
*/

/*
pos = 2

first = 2
second = null
count = 3

1 2 3 ... n
n n-1 n-2 .... 1

 */
// TODO unsolved
public class DelNthLastNode {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this(value, null);
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node deleteLast(Node head, int n) {
        Node slow = head;
        Node fast = head;

        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return null;

    }


    // O(2N)
    private static Node deleteNode(Node node, int n) {
        if (node == null) return null;
        Node head = node;
        int size = 0;

        while (node != null) {
            size++;

            node = node.next;
        }
        // size = 5
        if (n >= size) {
            // we cant del
            System.out.println("Cant delete");
            return head;
        } else {
            node = head;
            Node prev = null;
            int lastPosition = size; //3
            while (lastPosition != n) {
                prev = node; // prev = 1
                node = node.next; // n
                lastPosition--;
            }
            // lastPo = n
            if (prev == null) {
                return node.next;
            } else {
                prev.next = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
