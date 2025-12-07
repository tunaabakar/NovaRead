public class Reader {
    String name;
    String email;
    String username;

    Library library;
    Stack history;
    Queue readingQueue;

    public Reader(String name, String email, String username, Library library) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.library = library;
        this.history = new Stack();
        this.readingQueue = new Queue();
    }

    public void viewProfile() {
        System.out.println("Reader: " + name + " (" + username + ")");
        System.out.println("Email: " + email);
    }

    public void addToReadingQueue(Book book) {
        readingQueue.enqueue(book);
    }

    public void addToHistory(Book book) {
        history.push(book);
    }

    public void readNextBook() {
        Book next = readingQueue.dequeue();
        if (next != null) {
            System.out.println("Membaca buku: " + next);
            history.push(next);
        }
    }

    public void showReadingQueue() {
        readingQueue.display();
    }

    public void showHistory() {
        history.display();
    }
}
