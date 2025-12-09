public class DoublyLinkedList {
    Book data;
    DoublyLinkedList prev;
    DoublyLinkedList next;

    public DoublyLinkedList(Book data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    private DoublyLinkedList head;
    private DoublyLinkedList tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // menambah di depan
    public void addFirst(Book book) {
        DoublyLinkedList newNode = new DoublyLinkedList(book);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // menambah di belakang
    public void addLast(Book book) {
        DoublyLinkedList newNode = new DoublyLinkedList(book);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // INSERT
    public void insertAt(Book book, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index out of range!");
            return;
        }

        if (index == 0) {
            addFirst(book);
            return;
        }

        if (index == size) {
            addLast(book);
            return;
        }

        DoublyLinkedList newNode = new DoublyLinkedList(book);
        DoublyLinkedList current = head;
        int count = 0;

        while (count < index) {
            current = current.next;
            count++;
        }

        newNode.prev = current.prev;
        newNode.next = current;

        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    // hapus buku
    public void remove(Book book) {
        if (isEmpty()) {
            System.out.println("List kosong!");
            return;
        }

        DoublyLinkedList current = head;

        while (current != null) {
            if (current.data.equals(book)) {
                if (current == head) {
                    head = head.next;
                    if (head != null)
                        head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null)
                        tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                size--;
                return;
            }
            current = current.next;
        }

        System.out.println("Book tidak ditemukan dalam list!");
    }

    // Cetak list
    public void printList() {
        DoublyLinkedList temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Daftar buku kosong.");
            return;
        }

        DoublyLinkedList current = head;
        System.out.println("=== LIST BUKU ANDA ===");

        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }

        System.out.println("======================");
    }

    public DoublyLinkedList getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }
}