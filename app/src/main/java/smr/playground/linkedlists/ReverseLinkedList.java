package smr.playground.linkedlists;

public class ReverseLinkedList {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this(value, null);
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    private static Node reverse(Node node) {
        Node prev = null;
        while (node != null) {
            Node temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node ll = new Node(1, new Node(2, new Node(3)));
        printLinkedList(reverse(ll));
    }


}
