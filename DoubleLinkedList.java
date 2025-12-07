public class DoubleLinkedList {
    DLLNode head;
    DLLNode tail;
    int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Book book) {
        DLLNode newNode = new DLLNode(book);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Book book) {
        DLLNode newNode = new DLLNode(book);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void insertAt(Book book, int index) {
        if (index <= 0) {
            addFirst(book);
        } else if (index >= size) {
            addLast(book);
        } else {
            DLLNode newNode = new DLLNode(book);
            DLLNode current = head;
            int i = 0;
            while (current != null && i < index) {
                current = current.next;
                i++;
            }
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public boolean remove(Book book) {
        if (isEmpty()) return false;

        DLLNode current = head;
        while (current != null) {
            if (current.data.id == book.id) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void displayForward() {
        if (isEmpty()) {
            System.out.println("Daftar buku kosong.");
            return;
        }
        DLLNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public DLLNode getHead() {
        return head;
    }
}
