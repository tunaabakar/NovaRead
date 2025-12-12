import java.util.Scanner;

public class Favorite {
    Book book;
    Favorite head;
    Favorite tail;
    Favorite next;
    Favorite prev;

    // Konstruktor untuk membuat node favorit yang menyimpan satu Book.
    // Digunakan ketika menambahkan buku ke daftar favorit (sebagai node).
    public Favorite(Book book) {
        this.book = book;
        this.next = null;
        this.prev = null;
    }

    // Konstruktor tanpa argumen untuk membuat struktur daftar favorit kosong (container).
    // Gunakan ini ketika Anda ingin membuat daftar favorit baru yang akan menyimpan node-node.
    public Favorite() {
        this.book = null;
        this.head = null;
        this.tail = null;
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
            Book b = current.book;

            if (b != null) {
                String rating = (b.rating > 0) ? String.format(" | Rating: %.1f", b.rating) : "";
                System.out.println("- " + b.title + " by " + b.author + rating);
            } else {
                System.out.println("- <Unknown Book>");
            }

            current = current.next;
        }
    }
    public void printFavoriteTop3() {
        if (tail == null) {
            System.out.println("No favorite books.");
            return;
        }
        Favorite current = tail; // Buku paling baru
        int count = 0;
        while (current != null && count < 3) {
            System.out.println("- " + current.book.title + " by " + current.book.author);
            current = current.prev; // Mundur (seperti Stack)
            count++;
        }
    }

    public void manageFavoritesMenu(Scanner sc) {
        while (true) {
            printFavorite();
            System.out.println("\nMenu:");
            System.out.println("1. Remove a favorite");
            System.out.println("2. Back");
            System.out.print("Choose: ");
            int choice;
            while (!sc.hasNextInt()) {
                System.out.print("Masukkan angka: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Masukkan judul buku yang ingin dihapus: ");
                    String title = sc.nextLine();
                    removeFavorite(title);
                }
                case 2 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

}
