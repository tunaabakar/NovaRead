public class Reader {

    String name;
    String email;
    String username;
    Library library;
    Stack history;
    Queue readingQueue;

    public Reader(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;

        this.library = new Library(); // setiap reader punya library
        this.history = new Stack(); // riwayat bacaan
        this.readingQueue = new Queue(); // antrian buku
    }

    public void addBookToLibrary(Book book) {
        library.addBook(book);
        System.out.println(book.title + " berhasil ditambahkan ke Library.");
    }

    public void addToReadingQueue(Book book) {
        readingQueue.enqueue(book);
        System.out.println(book.title + " masuk ke Reading Queue.");
    }

    public void readNextBook() {
        if (readingQueue.isEmpty()) {
            System.out.println("Tidak ada buku dalam antrian.");
            return;
        }
        Book next = readingQueue.dequeue();
        history.push(next);
        System.out.println("Membaca: " + next.title);
    }
}