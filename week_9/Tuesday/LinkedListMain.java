class LinkedList {
  private Node head;
  public LinkedList() {
    head = null;
  }

  public void add(int data) {
    // TODO: add a new node to the linked list
    
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