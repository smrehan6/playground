package smr.playground;

/**
 * Just a generic implementation of BST
 * */
public class BinaryTreeSample {

    // TODO complete implementation

    static class Node<T> {
        T data;
        Node<T> left, right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree<T> {
        Node<T> root;

        BinaryTree(Node<T> node) {
            root = node;
        }

    }

    public static void main(String... args) {

        BinaryTree<Integer> bt = new BinaryTree<>(new Node<Integer>(5));

    }
}
