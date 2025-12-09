public class Reader {

    String name, email, username, password;
    Library library;
    Stack readingStack;
    Queue history;

    private DoublyLinkedList readingList;

    public Reader(String nm, String em, String uname, String pwd) {
        this.name = nm;
        this.email = em;
        this.username = uname;
        this.password = pwd;

        this.library = new Library();
        this.readingStack = new Stack();
        this.history = new Queue();
        this.readingList = new DoublyLinkedList();

    }

    public void addToLibrary(Book book) {
        library.addBook(book);
        System.out.println(book.title + " telah ditambahkan ke library anda");
    }

    public void addToReadingStack(Book book) {
        readingStack.push(book);
        System.out.println(book.title + " berhasil ditambahkan ke antrian bacaan.");
    }

    public void readNextBook() {
        if (readingStack.isEmpty()) {
            System.out.println("Tidak ada buku dalam antrian!");
            return;
        }

        Book next = readingStack.pop();
        System.out.println("Membaca buku: " + next.title);

        history.enqueue(next);

        readingList.addLast(next);
    }

    public DoublyLinkedList getReadingList() {
        return readingList;
    }
}
