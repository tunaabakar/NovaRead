public class Queue {
    Node front;
    Node rear;
    int size;

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(Book book) {
        Node newNode = new Node(book);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Book dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }
        Book removed = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return removed;
    }

    public Book peek() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar antrian baca:");
        Node current = front;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
