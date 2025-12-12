import java.util.Scanner;

public class Reader {
    String name, email, username, password;
    Library library;
    Stack history;        // Riwayat baca (LIFO)
    Queue readingQueue;   // Antrian buku untuk dibaca (FIFO)
    DoublyLinkedList readingList; 
    Favorite favorites;
    final Scanner sc;

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
        this.sc = new Scanner(System.in);
    }

    private void pause() {
        System.out.print("\nTekan ENTER untuk melanjutkan...");
        sc.nextLine();
    }

    public void displayBookDetail(Book book) {
        System.out.println();
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("       "+ book.title +"      ");
        System.out.println("═══════════════════════════════════════════════\n");

        System.out.println("Author  : " + book.author);
        System.out.println("Genre   : " + book.genre);
        System.out.println("Tag     : " + book.tag);
        System.out.println("Rating  : " + book.rating);
        System.out.println("Terakhir: " + book.lastDate);
        System.out.println("Sinopsis: " + book.desc);
    
        pause();
    }

    public void removeFromLibrary() {
        if (library.bookList.isEmpty()) {
            System.out.println("\nLibrary kamu masih kosong.");
            pause();
            return;
        }

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
            System.out.println("\nBuku \"" + title + "\" berhasil dihapus dari library.");
            pause();
        } else {
            System.out.println("\nBuku \"" + title + "\" tidak ditemukan di library.");
            pause();
        }
    }


    public void showMyLibrary() {
        if (library.bookList.isEmpty()) {
            System.out.println("\nLibrary kamu masih kosong.");
            pause();
            return;
        }

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
            sc.nextLine();

            switch (pilih) {
                case 1 -> sortingMenu();        
                case 2 -> viewBookDetailFromLibrary();
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


        // while (true) {
            System.out.println("\n=== Sorting Menu ===");
            System.out.println("1. Sort by Last Date (Terbaru dulu)");
            System.out.println("2. Sort by Title (A-Z)");
            System.out.println("3. Sort by Rating (Tinggi ke Rendah)");
            System.out.println("4. Back");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // buang newline

            switch (choice) {
                case 1 -> {Sorting.sortByDate(library.bookList); pause();}
                case 2 -> {Sorting.sortByTitle(library.bookList); pause();}
                case 3 -> {Sorting.sortByRating(library.bookList); pause();}
                case 4 -> { return; }
                default -> System.out.println("Pilihan tidak valid!");
            }
        // }
    }


    public void viewBookDetailFromLibrary() {
        if (library.bookList.isEmpty()) {
            System.out.println("Library kosong!");
            pause();
            return;
        }

        library.showLibrary();

        System.out.print("\nMasukkan judul buku untuk lihat detail: ");
        String title = sc.nextLine();

        Book selected = library.getBookByTitle(title);

        if (selected == null) {
            System.out.println("Buku tidak ditemukan!");
            pause();
            return;
        }

        displayBookDetail(selected); 
        history.push(selected);
    }

    // Tambah ke antrian baca (FIFO)
    public void addToReadingList(Book book) {
        library.addBook(book);
        readingQueue.enqueue(book);
    }

    // Lihat history
    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("Belum ada riwayat bacaan.");
            return;
        }
        System.out.println("=== History Bacaan (Terbaru di Atas) ===");
        history.display();
        pause();
    }

    public void showLastHistory() {
        history.displayTop3();
    }
    
    public void showTopFavorites() {
        favorites.printFavoriteTop3();
    }
    
    public DoublyLinkedList getReadingList() {
        return readingList;
    }

    // // Membaca buku berikutnya → Queue keluar duluan → masuk Stack history
    // public void readNextBook() {
    //     if (readingQueue.isEmpty()) {
    //         System.out.println("Tidak ada buku dalam antrian!");
    //         return;
    //     }

    //     Book next = readingQueue.dequeue();
    //     System.out.println("Membaca buku: " + next.title);

    //     // Masukkan ke history (Stack)
    //     history.push(next);

    //     // Simpan juga ke readingList
    //     readingList.addLast(next);
    // }

}
