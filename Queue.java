public class Queue {
    private static class Node {
        Book data;
        Node next;

        Node(Book data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

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
            System.out.println("Queue kosong.");
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
        if (isEmpty()) {
            System.out.println("Queue kosong.");
            return null;
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue kosong.");
            return;
        }

        Node temp = front;
        System.out.println("Antrian Buku:");
        while (temp != null) {
            System.out.println("- " + temp.data.title);
            temp = temp.next;
        }
    }
}