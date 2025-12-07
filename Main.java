public class Main {

    static void printLine() {
        System.out.println("────────────────────────────────────────────────────────────");
    }

    static void printBigTitle(String title) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("                  " + title);
        System.out.println("============================================================");
    }

    static void printSection(String title) {
        System.out.println();
        printLine();
        System.out.println( title);
        printLine();
    }

    public static void main(String[] args) {

        // ====== HEADER NOVAREAD ======
        System.out.println("============================================================");
        System.out.println("              NOVAREAD: Online Story Book");
        System.out.println("============================================================");
        System.out.println();


        Library library = new Library();
        Reader reader = new Reader(
                "Mutia Ayu",
                "mutiaa247@gmail.com.com",
                "mutiaayusa",
                library
        );

        printSection("Profil Reader");
        reader.viewProfile();


        // ====== 2. Tambah beberapa buku ke Library ======
        printBigTitle("PENGISIAN DATA BUKU KE LIBRARY");

        Book b1 = new Book(1, "Ocean Eyes", "Billie Eilish",
                "Romance", 4.8, "sad", "Soft romance story", "2025-12-01");

        Book b2 = new Book(2, "Dark Knight", "Bruce Wayne",
                "Mystery", 4.5, "crime", "Detective in the dark city", "2025-11-20");

        Book b3 = new Book(3, "Star Light", "Nova Sky",
                "Fantasy", 4.9, "magic", "Adventure among the stars", "2025-10-15");

        Book b4 = new Book(4, "Moon River", "Charlie",
                "Romance", 4.1, "calm", "Slow river-side love story", "2025-09-10");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);

        printSection("Daftar Buku di Library (Awal)");
        library.printAllBooks();


        // ====== 3. Test Sorting ======
        printBigTitle("FITUR SORTING (DoubleLinkedList)");

        printSection("Sort By Title (A -> Z)");
        library.sortByTitle();
        library.printAllBooks();

        printSection("Sort By Rating (Tertinggi -> Terendah)");
        library.sortByRating();
        library.printAllBooks();

        printSection("Sort By Genre (A -> Z)");
        library.sortByGenre();
        library.printAllBooks();

        printSection("Sort By Date (Last Read Terbaru -> Terlama)");
        library.sortByDate();
        library.printAllBooks();


        // ====== 4. Test Searching ======
        printBigTitle("FITUR SEARCHING");

        printSection("Search By Title: 'Star Light'");
        Book foundByTitle = Searching.searchByTitle(library.bookList, "Star Light");
        if (foundByTitle != null) {
            System.out.println(" Ditemukan: " + foundByTitle);
        } else {
            System.out.println("Buku tidak ditemukan.");
        }

        printSection("Search By Author: 'Billie Eilish'");
        Searching.searchByAuthor(library.bookList, "Billie Eilish");

        printSection("Search By Genre: 'Romance'");
        Searching.searchByGenre(library.bookList, "Romance");

        printSection("Search By Tag: 'magic'");
        Searching.searchByTag(library.bookList, "magic");


        // ====== 5. Tree Genre ======
        printBigTitle("TREE GENRE (Binary Search Tree)");

        printSection("Traversal Genre (In-Order)");
        library.showGenres();


        // ====== 6. Favorite ======
        printBigTitle("LIBRARY FAVORITE (Doubly Linked List)");

        printSection("Tambah Buku ke Daftar Favorite");
        library.favorites.addFavorite(b1);
        library.favorites.addFavorite(b3);
        library.favorites.printFavorite();

        printSection("Hapus Favorite dengan Judul 'Ocean Eyes'");
        library.favorites.removeFavorite("Ocean Eyes");
        library.favorites.printFavorite();


        // ====== 7. Queue (readingQueue di Reader) ======
        printBigTitle(" QUEUE (Reading Queue / Antrian Baca)");

        printSection("Tambah Buku ke Antrian Baca");
        reader.addToReadingQueue(b2);
        reader.addToReadingQueue(b4);
        reader.addToReadingQueue(b1);
        reader.showReadingQueue();

        printSection("Reader Membaca Buku Pertama di Antrian");
        reader.readNextBook();

        printSection("Antrian Baca Setelah readNextBook()");
        reader.showReadingQueue();


        // ====== 8. Stack (History Baca) ======
        printBigTitle(" STACK (History Baca)");

        printSection("Riwayat Baca Saat Ini");
        reader.showHistory();

        printSection("Tambahkan Buku 'Star Light' ke Riwayat Baca");
        reader.addToHistory(b3);

        System.out.println("Riwayat setelah penambahan:");
        reader.showHistory();


        // ====== AKHIR ======
        printBigTitle(" NOVAREAD SELESAI");
        System.out.println("Terima kasih telah menggunakan NOVAREAD ");
        System.out.println("Struktur data yang digunakan: DoubleLinkedList, Tree, Stack, Queue,");
        System.out.println("Sorting, dan Searching.");
        System.out.println("============================================================");
    }
}
