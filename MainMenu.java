import java.util.Scanner;

public class MainMenu {

    private ReaderList readerList;
    private BookDatabase bookDB;
    private Searching searching = new Searching();
    private Tree tree = new Tree();
    private Scanner sc;

    public MainMenu(ReaderList readerList, BookDatabase bookDB, Searching searching, Tree tree) {
        this.readerList = readerList;
        this.bookDB = bookDB;
        this.searching = searching;
        this.tree = tree;
        this.sc = new Scanner(System.in);
    }

    // =========================================================
    //                  CLEAR SCREEN / "CLS"
    // =========================================================
    private void clearScreen() {
        // ANSI escape code, biasanya berfungsi di terminal VS Code
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Kalau suatu saat di tempat lain tidak berfungsi,
        // kamu bisa ganti dengan:
        // for (int i = 0; i < 50; i++) System.out.println();
    }

    // =========================================================
    //                      START MENU
    // =========================================================
    public void start() {
        int choice;

        while (true) {
            printBanner();

            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║               NOVAREAD               ║");
            System.out.println("║        Your Personal Library         ║");
            System.out.println("╚══════════════════════════════════════╝\n");

            System.out.println(" 1. Login");
            System.out.println(" 2. Register");
            System.out.println(" 3. Exit");

            System.out.print("\nChoose: ");
            choice = getInt();

            switch (choice) {
                case 1 -> loginMenu();
                case 2 -> registerMenu();
                case 3 -> {
                    System.out.println("\nTerima kasih telah menggunakan NOVAREAD! 📚");
                    return;
                }
                default -> System.out.println("\n⚠ Pilihan tidak valid!");
            }
        }
    }

    // =========================================================
    //                       REGISTER
    // =========================================================
    private void registerMenu() {
        printBanner();

        System.out.println("╔══════════════════════╗");
        System.out.println("║       REGISTER       ║");
        System.out.println("╚══════════════════════╝");

        System.out.print("\nBuat Username : ");
        String username = sc.nextLine();

        if (readerList.exists(username)) {
            System.out.println("\n⚠ Username telah digunakan!");
            return;
        }

        System.out.print("Buat Password : ");
        String password = sc.nextLine();

        readerList.addReader(username, password);
        System.out.println("\n✔ Register berhasil!");
    }

    // =========================================================
    //                         LOGIN
    // =========================================================
    private void loginMenu() {
        printBanner();

        System.out.println("╔════════════════════╗");
        System.out.println("║        LOGIN       ║");
        System.out.println("╚════════════════════╝");

        System.out.print("\nUsername : ");
        String username = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        Reader user = readerList.login(username, password);

        if (user == null) {
            System.out.println("\n⚠ Login gagal!");
            return;
        }

        System.out.println("\n✔ Welcome, " + user.username + "!");
        userMenu(user);
    }

    // =========================================================
    //                       USER MENU
    // =========================================================
    private void userMenu(Reader user) {
        int option;

        while (true) {
            printBanner();
            System.out.println("╔════════════════════════════╗");
            System.out.println("║         USER MENU          ║");
            System.out.println("╚════════════════════════════╝\n");

            System.out.println(" 1. Show All Books");
            System.out.println(" 2. Search Book");
            System.out.println(" 3. Add Book to Favorites");
            System.out.println(" 4. Show My Favorite Books");
            System.out.println(" 5. Add Book to Reading Queue");
            System.out.println(" 6. Read Next Book");
            System.out.println(" 7. Show Reading History");
            System.out.println(" 8. Logout");

            System.out.print("\nChoose: ");
            option = getInt();

            switch (option) {
                case 1 -> bookDB.printAllDatabase();
                case 2 -> searchMenu();
                case 3 -> addFavorite(user);
                case 4 -> {
                    System.out.println("\n📚 Favorite Books:");
                    user.favorites.printFavorite();
                }
                case 5 -> addToReadingQueue(user);
                case 6 -> readNextBook(user);
                case 7 -> showReadingHistory(user);
                case 8 -> {
                    System.out.println("\n✔ Logged out.");
                    return;
                }
                default -> System.out.println("\n⚠ Invalid option!");
            }
        }
    }

    // =========================================================
    //                      SEARCH BOOK
    // =========================================================
    private void searchMenu() {
        printBanner();

        System.out.println("╔════════════════════════╗");
        System.out.println("║        SEARCH BOOK     ║");
        System.out.println("╚════════════════════════╝\n");

        System.out.println(" 1. Search by Title");
        System.out.println(" 2. Search by Author");
        System.out.println(" 3. Search by Genre (TREE)");
        System.out.println(" 4. Search by Tag");
        System.out.println(" 5. Back");

        System.out.print("\nChoose: ");
        int opt = getInt();

        DoublyLinkedList list = bookDB.allBooks;

        switch (opt) {
            case 1 -> {
                System.out.print("\nKeyword Judul : ");
                searching.searchByTitle(list, sc.nextLine());
            }
            case 2 -> {
                System.out.print("\nNama Author : ");
                searching.searchByAuthor(list, sc.nextLine());
            }
            case 3 -> {
                System.out.print("\nGenre : ");
                tree.searchByGenre(sc.nextLine());
            }
            case 4 -> {
                System.out.print("\nTag : ");
                searching.searchByTag(list, sc.nextLine());
            }
            case 5 -> { /* back */ }
            default -> System.out.println("\n⚠ Invalid input!");
        }
    }

    // =========================================================
    //                      ADD FAVORITE
    // =========================================================
    private void addFavorite(Reader user) {
        printBanner();
        System.out.println("╔════════════════════════╗");
        System.out.println("║      ADD FAVORITE      ║");
        System.out.println("╚════════════════════════╝\n");

        System.out.print("Judul Buku : ");
        String title = sc.nextLine();

        Book book = bookDB.searchOneByTitle(title);

        if (book == null) {
            System.out.println("\n⚠ Buku tidak ditemukan!");
            return;
        }

        user.favorites.addFavorite(book);
    }

    // =========================================================
    //             ADD TO READING QUEUE (STACK)
    // =========================================================
    private void addToReadingQueue(Reader user) {
        printBanner();
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║      ADD TO READING QUEUE       ║");
        System.out.println("╚══════════════════════════════════╝\n");

        System.out.print("Judul Buku : ");
        String title = sc.nextLine();

        Book book = bookDB.searchOneByTitle(title);

        if (book == null) {
            System.out.println("\n⚠ Buku tidak ditemukan!");
            return;
        }

        user.addToReadingList(book);
    }

    // =========================================================
    //                 READ NEXT BOOK
    // =========================================================
    private void readNextBook(Reader user) {
        printBanner();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║        READ NEXT BOOK        ║");
        System.out.println("╚══════════════════════════════╝\n");

        user.readNextBook();
    }

    // =========================================================
    //                 SHOW READING HISTORY
    // =========================================================
    private void showReadingHistory(Reader user) {
        printBanner();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║        READING HISTORY       ║");
        System.out.println("╚══════════════════════════════╝\n");

        user.showHistory();
    }

    // =========================================================
    //                   SAFE INTEGER INPUT
    // =========================================================
    private int getInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Masukkan angka: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    // =========================================================
    //                         BANNER
    // =========================================================
    private void printBanner() {
        clearScreen();   // <<--- INI YANG BIKIN EFEK "CLS"

       System.out.println("                                                               ");
System.out.println("   ▄▄     ▄▄▄                  ▄▄▄▄▄▄                     ");
System.out.println("   ██▄   ██▀                  █▀██▀▀▀█▄                 █▄");
System.out.println("   ███▄  ██                     ██▄▄▄█▀                 ██");
System.out.println("   ██ ▀█▄██ ▄███▄▀█▄ ██▀▄▀▀█▄   ██▀▀█▄   ▄█▀█▄ ▄▀▀█▄ ▄████");
System.out.println("   ██   ▀██ ██ ██ ██▄██ ▄█▀██ ▄ ██  ██   ██▄█▀ ▄█▀██ ██ ██");
System.out.println(" ▀██▀    ██▄▀███▀  ▀█▀ ▄▀█▄██ ▀██▀  ▀██▀▄▀█▄▄▄▄▀█▄██▄█▀███");
System.out.println("                                                               ");
System.out.println("                                                               ");
    }
}
