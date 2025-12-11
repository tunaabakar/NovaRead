public class Reader {
    String name, email, username, password;
    Library library;
    Stack readingStack;
    Queue history;
    DoublyLinkedList readingList;
    Favorite favorites;

    public Reader(String nm, String em, String uname, String pwd) {
        this.name = nm;
        this.email = em;
        this.username = uname;
        this.password = pwd;

        this.library = new Library(); // Koleksi buku yang dimiliki pembaca
        this.readingStack = new Stack(); // Antrian buku yang akan dibaca
        this.history = new Queue(); // Riwayat buku yang sudah dibaca
        this.readingList = new DoublyLinkedList(); // Daftar buku yang sedang dibaca
        this.favorites = new Favorite(); // Daftar buku favorit pembaca

    }

    public Reader(String uname, String pass) {
        this.username = uname;
        this.password = pass;
        
        this.library = new Library(); // Koleksi buku yang dimiliki pembaca
        this.readingStack = new Stack(); // Antrian buku yang akan dibaca
        this.history = new Queue(); // Riwayat buku yang sudah dibaca
        this.readingList = new DoublyLinkedList(); // Daftar buku yang sedang dibaca
        this.favorites = new Favorite(); // Daftar buku favorit pembaca
    }

    public void addToLibrary(Book book) {
        library.addBook(book);
        System.out.println(book.title + " telah ditambahkan ke library anda");
    }

    public void addToReadingList(Book book) {
        readingStack.push(book);
        System.out.println(book.title + " berhasil ditambahkan ke antrian bacaan.");
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("Belum ada riwayat bacaan.");
            return;
        }
        System.out.println("History bacaan:");
        history.printQueue();
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
