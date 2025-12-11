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

    // =============== MENU UTAMA ===============
    public void start() {
        int choice;

        while (true) {
            printBanner();
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║          NOVAREAD            ║");
            System.out.println("║      Your Reading Journey    ║");
            System.out.println("╚══════════════════════════════╝\n");

            System.out.println("1.  Login");
            System.out.println("2.  Register");
            System.out.println("3.  Exit");
            System.out.print("\nChoose: ");

            choice = getInt();

            switch (choice) {
                case 1 -> loginMenu();
                case 2 -> registerMenu();
                case 3 -> {
                    System.out.println("Terima kasih telah menggunakan NOVAREAD!");
                    return;
                }
                default -> {
                    System.out.println("Pilihan tidak valid!");
                }
            }
        }
    }

    // =============== REGISTER ===============
    private void registerMenu() {
        printBanner();
        System.out.println("╔══════════════════════╗");
        System.out.println("║       REGISTER       ║");
        System.out.println("╚══════════════════════╝");

        System.out.print("\nBuat Username : ");
        String username = sc.nextLine();

        if (readerList.exists(username)) {
            System.out.println("⚠ Username sudah digunakan!");
            return;
        }

        System.out.print("Buat Password : ");
        String password = sc.nextLine();

        readerList.addReader(username, password);
        System.out.println("✔ Register berhasil!");
    }

    // =============== LOGIN ===============
    private void loginMenu() {
        printBanner();
        System.out.println("╔════════════════════╗");
        System.out.println("║       LOGIN        ║");
        System.out.println("╚════════════════════╝");

        System.out.print("\nUsername : ");
        String username = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        Reader user = readerList.login(username, password);

        if (user == null) {
            System.out.println(" Login gagal!");
            return;
        }

        System.out.println("\n✔ Welcome, " + user.username + "!");
        userMenu(user);
    }

    // =============== USER MENU ===============
    private void userMenu(Reader user) {
        int option;

        while (true) {
            printBanner();
            System.out.println("╔════════════════════════════╗");
            System.out.println("║         USER MENU          ║");
            System.out.println("╚════════════════════════════╝\n");

            System.out.println("1.  Show All Books");
            System.out.println("2.  Search Book");
            System.out.println("3.  Add Book to Favorites");
            System.out.println("4.  Show My Library");
            System.out.println("5.  Logout");

            System.out.print("\nChoose: ");
            option = getInt();

            switch (option) {
                case 1 -> bookDB.printAllDatabase();
                
                case 2 -> searchMenu();
                case 3 -> addFavorite(user);
                case 4 -> {
                    System.out.println(" Favorite Books:");
                    user.favorites.printFavorite();
                }
                case 5 -> {
                    System.out.println(" Logged out.");
                    return;
                }
                default -> System.out.println(" Invalid option!");
            }
        }
    }

    // =============== SEARCH BOOKS ===============
    private void searchMenu() {
        printBanner();
        System.out.println("╔════════════════════════╗");
        System.out.println("║        SEARCH BOOK     ║");
        System.out.println("╚════════════════════════╝\n");

        System.out.println("1.  Search by Title");
        System.out.println("2.  Search by Author");
        System.out.println("3.  Search by Genre");
        System.out.println("4.  Search by Tag");
        System.out.println("5.  Back");
        System.out.print("\nChoose: ");

        int opt = getInt();
        DoublyLinkedList list = bookDB.allBooks;

        switch (opt) {
            case 1 -> {
                System.out.print("\nKeyword Judul : ");
                String key = sc.nextLine();
                searching.searchByTitle(list, key);
            }
            case 2 -> {
                System.out.print("\nNama Author : ");
                String key = sc.nextLine();
                searching.searchByAuthor(list, key);
            }
            case 3 -> {
                System.out.print("\nGenre : ");
                String key = sc.nextLine();
                tree.searchByGenre(key);
            }
            case 4 -> {
                System.out.print("\nTag : ");
                String key = sc.nextLine();
                searching.searchByTag(list, key);
            }
            case 5 -> { return; }

            default -> System.out.println(" Invalid input!");
        }
    }

    // =============== ADD FAVORITE ===============
    private void addFavorite(Reader user) {
        printBanner();
        System.out.println(" ADD TO FAVORITE ");

        System.out.print("Judul Buku : ");
        String title = sc.nextLine();

        Book book = bookDB.searchOneByTitle(title);

        if (book == null) {
            System.out.println(" Book not found!");
            return;
        }

        user.favorites.addFavorite(book);
    }

    // =============== SAFE INTEGER INPUT ===============
    private int getInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Masukkan angka: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    private void printBanner() {
    System.out.println("                                                               ");
    System.out.println("   ▄▄     ▄▄▄                  ▄▄▄▄▄▄                     ");
    System.out.println("   ██▄   ██▀                  █▀██▀▀▀█▄                 █▄");
    System.out.println("   ███▄  ██                     ██▄▄▄█▀                 ██");
    System.out.println("   ██ ▀█▄██ ▄███▄▀█▄ ██▀▄▀▀█▄   ██▀▀█▄   ▄█▀█▄ ▄▀▀█▄ ▄████");
    System.out.println("   ██   ▀██ ██ ██ ██▄██ ▄█▀██ ▄ ██  ██   ██▄█▀ ▄█▀██ ██ ██");
    System.out.println(" ▀██▀    ██▄▀███▀  ▀█▀  ▀█▄██ ▀██▀  ▀██▀▄▀█▄▄▄▄▀█▄██▄█▀███");
    System.out.println("                                                               ");
}

}
