import java.util.Scanner;

public class MainMenu {

    final ReaderList readerList;
    final BookDatabase bookDB;
    private Searching searching = new Searching();
    private Tree tree = new Tree();
    final Scanner sc;

    public MainMenu(ReaderList readerList, BookDatabase bookDB, Searching searching, Tree tree) {
        this.readerList = readerList;
        this.bookDB = bookDB;
        this.searching = searching;
        this.tree = tree;
        this.sc = new Scanner(System.in);
    }

    private void pause() {
        System.out.print("\nTekan ENTER untuk melanjutkan...");
        sc.nextLine();
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
                default -> System.out.println("\n Pilihan tidak valid!");
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

        if (sc.hasNextLine()){ sc.nextLine();}

        System.out.print("\nBuat Username : ");
        String username = sc.nextLine();

        if (readerList.exists(username)) {
            System.out.println("\n Username telah digunakan!");
            return;
        }

        System.out.print("Buat Password : ");
        String password = sc.nextLine();

        System.out.print("Nama Lengkap : ");
        String name = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        readerList.addReader(username, password, name, email);
        System.out.println("\n Register berhasil!");
        pause();
    }

    // =========================================================
    //                         LOGIN
    // =========================================================
    private void loginMenu() {
        printBanner();

        System.out.println("╔════════════════════╗");
        System.out.println("║        LOGIN       ║");
        System.out.println("╚════════════════════╝");

        if (sc.hasNextLine()){ sc.nextLine();}
        
        System.out.print("\nUsername : ");
        String username = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        Reader user = readerList.login(username, password);

        if (user == null) {
            System.out.println("\n Login gagal!");
            pause();
            return;
        }

        System.out.println("\n Welcome, " + user.username + "!");
        pause();
        userMenu(user);
    }

    // =========================================================
    //                       USER MENU
    // =========================================================
    private void userMenu(Reader user){
        int option;

        while (true) {
            printBanner();
            System.out.println("════════════════════════════════════════════════════════");
            System.out.println("     "+user.name+" MENU");
            System.out.println("════════════════════════════════════════════════════════\n");
            //bakal ngelihatin reading history kita(buku terakhir yang ditambahkan)
            System.out.println("═════════Your History════════");
            user.showLastHistory();
            System.out.println();
            //ngelihatin list buku favorite
            System.out.println("════════Your Favorites═══════");
            user.showTopFavorites();
            System.out.println();
            System.out.println(" 1. Show All Books");
            System.out.println(" 2. Search Book");
            System.out.println(" 3. Show My Library");
            System.out.println(" 4. Show My Favorite");
            System.out.println(" 5. Logout");
            System.out.print("\nChoose: ");
            option = getInt();

            switch (option) {
                case 1 -> {
                    bookDB.printAllDatabase();
                    System.out.println("\n1. Lihat detail buku");
                    System.out.println("2. Kembali");
                    System.out.print("Pilih: ");
                    int pilih = getInt();
                    if (pilih == 1) {
                        selectBookDetail(user);
                        pause();
                    }
                }
                case 2 -> searchMenu();
                case 3 -> user.showMyLibrary();
                case 4 -> {
                    System.out.println("\n Favorite Books:");
                    user.favorites.manageFavoritesMenu(sc);
                    pause();
                }
                case 5 -> {
                    System.out.println("\n Logged out.");
                    pause();
                    return;
                }
                default -> {System.out.println("\n Invalid option!");  pause();}
            }
        }
    }
    // public void ProfileMenu(Reader user) {
    //     int choice;

    //     while (true) {
    //         clearScreen();
    //         System.out.println("╔══════════════════════════════╗");
    //         System.out.println("║          USER PROFILE        ║");
    //         System.out.println("╚══════════════════════════════╝\n");

    //         System.out.println("Username : " + user.username);
    //         System.out.println("Nama     : " + user.name);
    //         System.out.println("Email    : " + user.email);

    //         System.out.println("\nMenu:");
    //         System.out.println("1. Edit Nama");
    //         System.out.println("2. Edit Email");
    //         System.out.println("3. Back");
    //         System.out.print("\nPilih: ");

    //         while (!sc.hasNextInt()) {
    //             System.out.print("Masukkan angka: ");
    //             sc.next();
    //         }
    //         choice = sc.nextInt();
    //         sc.nextLine(); // clear buffer

    //         switch (choice) {
    //             case 1 -> {
    //                 System.out.print("Masukkan nama baru: ");
    //                 String newName = sc.nextLine();
    //                 user.name = newName;
    //                 System.out.println(" Nama berhasil diupdate!");
    //                 pause();
    //             }
    //             case 2 -> {
    //                 String newEmail;
    //                 while (true) {
    //                     System.out.print("Masukkan email baru (@gmail.com): ");
    //                     newEmail = sc.nextLine();
    //                     if (newEmail.endsWith("@gmail.com")) break;
    //                     System.out.println(" Email harus diakhiri dengan @gmail.com");
    //                 }
    //                 user.email = newEmail;
    //                 System.out.println(" Email berhasil diupdate!");
    //                 pause();
    //             }
    //             case 3 -> { return; }
    //             default -> System.out.println(" Pilihan tidak valid!");
    //         }
    //     }
    // }


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
        System.out.println(" 3. Search by Genre");
        System.out.println(" 4. Search by Tag");
        System.out.println(" 5. Back");

        System.out.print("\nChoose: ");
        int opt = getInt();

        DoublyLinkedList list = bookDB.allBooks;

        switch (opt) {
            case 1 -> {
                System.out.print("\nKeyword Judul : ");
                searching.searchByTitle(list, sc.nextLine());
                pause();
            }
            case 2 -> {
                System.out.print("\nNama Author : ");
                searching.searchByAuthor(list, sc.nextLine());
                pause();
            }
            case 3 -> {
                System.out.print("\nGenre : ");
                tree.searchByGenre(sc.nextLine());
                pause();
            }
            case 4 -> {
                System.out.print("\nTag : ");
                searching.searchByTag(list, sc.nextLine());
                pause();
            }
            case 5 -> { /* back */ }
            default -> System.out.println("\n Invalid input!");
        }
    }

    private void selectBookDetail(Reader user) {
            if (bookDB.allBooks.isEmpty()) {
                System.out.println("\n Tidak ada buku di database!");
                pause(); return;
            }

            System.out.print("Masukkan judul buku: ");
            String title = sc.nextLine();

            Book selected = bookDB.getBookByTitle(title);

            if (selected == null) {
                System.out.println("\n Buku tidak ditemukan!");
                pause(); return;
            }
            System.out.println("╔═════════════════════════════╗");
            System.out.println("║         DETAIL BUKU         ║");
            System.out.println("╚═════════════════════════════╝\n");

            System.out.println("Judul   : " + selected.title);
            System.out.println("Author  : " + selected.author);
            System.out.println("Genre   : " + selected.genre);
            System.out.println("Tag     : " + selected.tag);
            System.out.println("Rating  : " + selected.rating);
            System.out.println("Terakhir: " + selected.lastDate);

            System.out.println("\nApa yang ingin kamu lakukan?");
            System.out.println("1. Tambahkan ke Favorite");
            System.out.println("2. Tambahkan ke Library");
            System.out.println("3. Kembali");

            System.out.print("\nPilih: ");
            int opt = getInt();

            switch (opt) {
                case 1 -> {
                    user.favorites.addFavorite(selected);
                    System.out.println("Berhasil ditambahkan!");
                    pause();
                }
                case 2 -> {
                    user.addToReadingList(selected);
                    System.out.println("Berhasil ditambahkan!");
                    pause();
                }
                case 3 -> { return; }
                default -> System.out.println("\n⚠ Input tidak valid!");
            }

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
