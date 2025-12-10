public class Favorite {
    Book book;
    Favorite head;
    Favorite tail;
    Favorite next;
    Favorite prev;

    // Constructor untuk LIST kosong (dipakai di Main: new Favorite())
    public Favorite() {
        this.book = null;
        this.head = null;
        this.tail = null;
        this.next = null;
        this.prev = null;
    }

    // Constructor untuk NODE berisi 1 buku (dipakai di addFavorite)
    public Favorite(Book book) {
        this.book = book;
        this.next = null;
        this.prev = null;
    }

    public void addFavorite(Book book) {
        Favorite newNode = new Favorite(book);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println(book.title + " added to favorites.");
    }

    public void removeFavorite(String title) {
        Favorite current = head;

        while (current != null) {
            if (current.book.title.equalsIgnoreCase(title)) {

                if (current == head) {
                    head = current.next;
                    if (head != null)
                        head.prev = null;
                }

                if (current == tail) {
                    tail = current.prev;
                    if (tail != null)
                        tail.next = null;
                }

                if (current.prev != null)
                    current.prev.next = current.next;
                if (current.next != null)
                    current.next.prev = current.prev;

                System.out.println(title + " removed from favorites.");
                return;
            }
            current = current.next;
        }

        System.out.println(title + " not found in favorites.");
    }

    public Book findFavorite(String title) {
        Favorite current = head;

        while (current != null) {
            if (current.book.title.equalsIgnoreCase(title)) {
                return current.book;
            }
            current = current.next;
        }
        return null;
    }

    public void printFavorite() {
        if (head == null) {
            System.out.println("No favorite books.");
            return;
        }

        System.out.println("Favorite Books List:");
        Favorite current = head;
        while (current != null) {
            System.out.println("- " + current.book);
            current = current.next;
        }
    }
}
