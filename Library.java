public class Library {
    public DoublyLinkedList bookList;

    public Library() {
        bookList = new DoublyLinkedList(); // library langsung punya DLL
    }

    // menambahkan buku ke library
    public void addBook(Book book) {
        bookList.addLast(book);
    }

    // menampilkan semua buku
    public void showLibrary() {
        if (bookList.isEmpty()) {
            System.out.println("Library masih kosong.");
            return;
        }
        bookList.display();
    }

    public Book getBookByTitle(String title) {
        DoublyLinkedList current = bookList.head;

        while (current != null) {
            if (current.data != null) {
                String bookTitle = current.data.title.toLowerCase();
                String input = title.toLowerCase();

                if (bookTitle.contains(input)) {
                    return current.data;
                }
            }
            current = current.next;
        }

        return null; // tidak ditemukan
    }

}