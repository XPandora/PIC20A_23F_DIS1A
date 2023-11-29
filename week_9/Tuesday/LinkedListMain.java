class LinkedList {
  private Node head;

  public LinkedList() {
    head = null;
  }

  public void add(int data) {
    // step 1: initialize an instance of Node
    Node n = new Node(data);

    // step 2: append this Node n to the tail of this linked list
    // corner case: no nodes in this linked list
    if (head == null) {
      head = n;
    } else {
      // means we do have some nodes inside this linked list
      // we have to find the tail of this list
      Node node = head;
      while (node.next != null) {
        node = node.next;
      }

      // after the while loop, node is the tail of this linked list
      // because its next is null
      node.next = n;
    }
  }

  public void print() {
    Node node = this.head;
    while (node != null) {
      System.out.println(node.data);
      node = node.next;
    }
  }

  private class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      next = null;
    }
  }
}

public class LinkedListMain {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    list.print();
  }
}