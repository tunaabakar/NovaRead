public class BookDatabase {
    public DoublyLinkedList allBooks;

    public BookDatabase() {
        allBooks = new DoublyLinkedList();
    }

    public void addBookToDatabase(Book b) {
        allBooks.addLast(b);
    }


    // public Book searchOneByTitle(String title) {
    //     DoublyLinkedList current = allBooks.getHead();

    //     while (current != null) {
    //         Book b = current.data;
    //         if (b.title != null && b.title.equalsIgnoreCase(title)) {
    //             return b;
    //         }
    //         current = current.next;
    //     }

    //     return null; // kalau tidak ditemukan
    // }
    public Book getBookByTitle(String title) {
        DoublyLinkedList current = allBooks.head;

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

    public void printAllDatabase() {
        System.out.println("=== Semua Buku di Database ===");
        allBooks.display();
    }

}
