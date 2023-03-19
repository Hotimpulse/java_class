public class RedBlackTree {
    private Node root;

    private enum Color {
        RED, BLACK
    }

    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        Node(int value) {
            this.value = value;
            color = Color.RED;
        }
    }

    public void add(int value) {
        root = addNode(root, value);
        root.color = Color.BLACK;
    }

    private Node addNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = addNode(node.left, value);
        } else if (value > node.value) {
            node.right = addNode(node.right, value);
        } else {
            return node;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == Color.RED;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.color = node.color;
        node.color = Color.RED;
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.color = node.color;
        node.color = Color.RED;
        return newRoot;
    }

    private void flipColors(Node node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    public boolean find(int value) {
        Node node = root;
        while (node != null) {
            if (value == node.value) {
                return true;
            } else if (value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    public void print() {
        printNode(root, "", true);
    }

    private void printNode(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value + (node.color == Color.BLACK ? " (B)" : " (R)"));
            printNode(node.left, prefix + (isTail ? "    " : "│   "), node.right == null);
            printNode(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(2);
        tree.add(4);
        tree.add(7);
        tree.add(9);

        tree.print(); //tree before balancing

        // adding some values to the tree
        tree.add(6);
        tree.add(10);

        // activating left rotation by searching for and finding the node with value 8
        tree.find(8);

        tree.print(); //tree after balancing
    }
}
