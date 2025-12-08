public class Library {

    DoublyLinkedList bookList;

    public Library() {
        bookList = new DoublyLinkedList(); // library langsung punya DLL
    }

    // Menambahkan buku ke library
    public void addBook(Book book) {
        bookList.addLast(book);
    }

    // Menampilkan semua buku
    public void showLibrary() {
        if (bookList.isEmpty()) {
            System.out.println("Library masih kosong.");
            return;
        }
        bookList.display();
    }
}