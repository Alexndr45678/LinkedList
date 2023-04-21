

public class ReverseLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    public void bubbleSort() {
        if (head == null) {
            return;
        }
        boolean swap;
        Node left = head;
        Node right = null;

        do {
            swap = false;
            Node current = left;

            while (current.next != right) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swap = true;
                }
                current = current.next;
            }
            right = current;
        } while (swap);
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;
        if (head != null) {
            head.prev = new_node;
        }
        head = new_node;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);

        System.out.print("Initial list: ");
        list.printList();

        list.reverse();
        System.out.print("Reversed list: ");
        list.printList();

        list.reverse();
        list.printList();
        list.bubbleSort();

        System.out.print("Bubble sorted list: ");
        list.printList();
    }
}

