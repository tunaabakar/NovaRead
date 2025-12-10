public class Stack {

    private class Node {
        Book data;
        Node next;

        Node(Book data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Book book) {
        Node newNode = new Node(book);
        newNode.next = top;
        top = newNode;
    }

    public Book pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return null;
        }

        Book removed = top.data;
        top = top.next;
        return removed;
    }

    public Book peek() {
        if (isEmpty())
            return null;
        return top.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("History kosong.");
            return;
        }

        Node current = top;
        System.out.println("=== HISTORY BACA ===");
        while (current != null) {
            System.out.println(current.data.title);
            current = current.next;
        }
        System.out.println("====================");
    }
}