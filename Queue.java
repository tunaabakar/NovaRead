public class Queue {

    private class Node {
        Book data;
        Node next;

        Node(Book data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Book book) {
        Node newNode = new Node(book);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Book dequeue() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
            return null;
        }

        Book removed = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return removed;
    }

    public Book peek() {
        if (isEmpty())
            return null;
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue kosong.");
            return;
        }

        Node current = front;
        System.out.println("=== READING QUEUE ===");
        while (current != null) {
            System.out.println(current.data.title);
            current = current.next;
        }
        System.out.println("=====================");
    }
}
