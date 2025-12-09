public class Library {

    DoublyLinkedList bookList;

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
}