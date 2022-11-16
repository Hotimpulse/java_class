package java_class.Seminar5;

public class app {
  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    Node n9 = new Node(9);
    Node n11 = new Node(11);
    Node n20 = new Node(20);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n4.left = n7;
    n4.right = n9;
    n3.left = n5;
    n3.right = n6;
    n6.left = n11;
    n6.right = n20;
    preOrder(n1);
  }
  static void preOrder(Node root) {
    if(root!=null){
      System.out.print(root.value + " ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }
}

class Node {
  int value;
  public Node(int value) {
    this.value = value;
  }
  Node left;
  Node right;
}
//           1
//         /   \
//       2      3
//      /      /  \
//     4     5     6
//   /   \        / \
//  7     9     11   20