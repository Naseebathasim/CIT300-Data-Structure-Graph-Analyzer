public class LinkedList {

    private Node head;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert a new value at the end of the list
    public void insert(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Value inserted successfully.");
    }

    // Delete a value from the list
    public void delete(int value) {

        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        // Delete first node
        if (head.data == value) {
            head = head.next;
            System.out.println("Value deleted successfully.");
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data != value) {

            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Value deleted successfully.");
        }
    }

    // Search for a value
    public void search(int value) {

        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        Node current = head;
        int position = 0;

        while (current != null) {

            if (current.data == value) {
                System.out.println(
                    "Value found at position: " + position
                );
                return;
            }

            current = current.next;
            position++;
        }

        System.out.println("Value not found.");
    }

    // Display all values
    public void display() {

        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        System.out.print("Linked List: ");

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }
}