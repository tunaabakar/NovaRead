import java.util.Scanner;

public class Reader {
    String name, email, username, password;
    Library library;
    Stack history;        // Riwayat baca (LIFO)
    Queue readingQueue;   // Antrian buku untuk dibaca (FIFO)
    DoublyLinkedList readingList; 
    Favorite favorites;
    MainMenu menu;
    

    public Reader(String uname, String pwd, String nm, String em) {
        this.username = uname;
        this.password = pwd;
        this.name = nm;
        this.email = em;

        this.library = new Library();
        this.readingQueue = new Queue();  // Perbaikan di sini
        this.history = new Stack();       // Dan di sini
        this.readingList = new DoublyLinkedList();
        this.favorites = new Favorite();
    }

    // public Reader(String uname, String pass) {
    //     this.username = uname;
    //     this.password = pass;

    //     this.library = new Library();
    //     this.readingQueue = new Queue();  // Perbaikan
    //     this.history = new Stack();       // Perbaikan
    //     this.readingList = new DoublyLinkedList();
    //     this.favorites = new Favorite();
    // }

    // Tambah ke library
    public void addToLibrary(Book book) {
        library.addBook(book);
        System.out.println(book.title + " telah ditambahkan ke library anda");
    }

    public void removeFromLibrary() {
        if (library.bookList.isEmpty()) {
            System.out.println("\nLibrary kamu masih kosong.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        library.showLibrary();

        System.out.print("\nMasukkan judul buku yang ingin dihapus: ");
        String title = sc.nextLine();

        DoublyLinkedList current = library.bookList.getHead();
        Book bookToRemove = null;

        while (current != null) {
            if (current.data != null && current.data.title != null &&
                current.data.title.equalsIgnoreCase(title)) {
                bookToRemove = current.data;
                break;
            }
            current = current.next;
        }

        if (bookToRemove != null) {
            library.bookList.remove(bookToRemove);
            System.out.println("\n✔ Buku \"" + title + "\" berhasil dihapus dari library.");
        } else {
            System.out.println("\n⚠ Buku \"" + title + "\" tidak ditemukan di library.");
        }
    }


    public void showMyLibrary() {
        if (library.bookList.isEmpty()) {
            System.out.println("\nLibrary kamu masih kosong.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int pilih;

        while (true) {
            System.out.println("\n======= My Library =======");
            library.showLibrary();

            System.out.println("\nMENU:");
            System.out.println("1. Sort Library");
            System.out.println("2. Pilih Buku untuk Dibaca");
            System.out.println("3. Hapus Buku dari Library");
            System.out.println("4. Back");
            System.out.print("Choose: ");

            pilih = sc.nextInt();

            switch (pilih) {
                case 1 -> sortingMenu();        // buka submenu sorting
                case 2 -> viewBookDetailFromLibrary();  // pilih 1 buku untuk dibaca
                case 3 -> removeFromLibrary();
                case 4 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void sortingMenu() {
        if (library.bookList.isEmpty()) {
            System.out.println("\nLibrary kamu masih kosong.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sorting Menu ===");
            System.out.println("1. Sort by Last Date (Terbaru dulu)");
            System.out.println("2. Sort by Title (A-Z)");
            System.out.println("3. Sort by Rating (Tinggi ke Rendah)");
            System.out.println("4. Back");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // buang newline

            switch (choice) {
                case 1 -> Sorting.sortByDate(library.bookList);
                case 2 -> Sorting.sortByTitle(library.bookList);
                case 3 -> Sorting.sortByRating(library.bookList);
                case 4 -> { return; }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }


    public void viewBookDetailFromLibrary() {
        if (library.bookList.isEmpty()) {
            System.out.println("Library kosong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        library.showLibrary();

        System.out.print("\nMasukkan judul buku untuk lihat detail: ");
        String title = sc.nextLine();

        // pakai getBookByTitle dari BookDatabase
        Book selected = library.getBookByTitle(title);

        if (selected == null) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }

        menu.displayBookDetail(selected); // tampilkan detail buku
    }

    // Tambah ke antrian baca (FIFO)
    public void addToReadingList(Book book) {
        readingQueue.enqueue(book);
        System.out.println(book.title + " berhasil ditambahkan ke antrian bacaan.");
    }

    // Lihat history
    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("Belum ada riwayat bacaan.");
            return;
        }
        System.out.println("=== History Bacaan (Terbaru di Atas) ===");
        history.display();
    }

    public void showLastHistory() {
        history.displayTop3();
    }
    
    public void showTopFavorites() {
        favorites.printFavoriteTop3();
    }

    // Membaca buku berikutnya → Queue keluar duluan → masuk Stack history
    public void readNextBook() {
        if (readingQueue.isEmpty()) {
            System.out.println("Tidak ada buku dalam antrian!");
            return;
        }

        Book next = readingQueue.dequeue();
        System.out.println("Membaca buku: " + next.title);

        // Masukkan ke history (Stack)
        history.push(next);

        // Simpan juga ke readingList
        readingList.addLast(next);
    }

    public DoublyLinkedList getReadingList() {
        return readingList;
    }
}
