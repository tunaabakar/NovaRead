public class BookDatabase {
    public DoublyLinkedList allBooks;

    public BookDatabase() {
        allBooks = new DoublyLinkedList();
    }

    public void addBookToDatabase(Book b) {
        allBooks.addLast(b);
    }

    public Book findByTitle(String title) {
        DoublyLinkedList cur = allBooks.getHead();
        while (cur != null) {
            if (cur.data != null && cur.data.title != null &&
                    cur.data.title.equalsIgnoreCase(title)) {
                return cur.data;
            }
            cur = cur.next;
        }
        return null;
    }

    public Book searchOneByTitle(String title) {
        DoublyLinkedList current = allBooks.getHead();

        while (current != null) {
            Book b = current.data;
            if (b.title != null && b.title.equalsIgnoreCase(title)) {
                return b;
            }
            current = current.next;
        }

        return null; // kalau tidak ditemukan
    }

    public void printAllDatabase() {
        System.out.println("=== Semua Buku di Database ===");
        allBooks.display();
    }
}
