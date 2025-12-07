public class Stack {
    Node top;
    int size;

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void push(Book book) {
        Node newNode = new Node(book);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Book pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return null;
        }
        Book removed = top.data;
        top = top.next;
        size--;
        return removed;
    }

    public Book peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return null;
        }
        return top.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Riwayat baca kosong.");
            return;
        }
        System.out.println("Riwayat buku yang dibaca (terbaru -> terlama):");
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
