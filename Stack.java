public class Stack {
    private static class Node {
        Book data;
        Node next;

        Node(Book data) {
            this.data = data;
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
            System.out.println("Stack kosong, belum ada buku yang kamu baca.");
            return null;
        }

        Book removed = top.data;
        top = top.next;
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
            System.out.println("Stack kosong.");
            return;
        }

        Node temp = top;
        System.out.println("Riwayat Buku yang Pernah Dibaca:");
        while (temp != null) {
            System.out.println("- " + temp.data.title);
            temp = temp.next;
        }
    }
}
