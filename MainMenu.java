import java.util.Scanner;

public class MainMenu {

    private ReaderList readerList; // Linked list berisi data user
    private BookDatabase bookDB; // Database buku (dari Main)
    private Searching searching = new Searching(); // Search engine
    private Scanner sc;

    public MainMenu(ReaderList readerList, BookDatabase bookDB, Searching searching) {
        this.readerList = readerList;
        this.bookDB = bookDB;
        this.searching = searching;
        this.sc = new Scanner(System.in);
    }

    // =============== MENU UTAMA ===============
    public void start() {
        int choice;
        while (true) {
            System.out.println("\n====== NOVAREAD ======");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            choice = getInt();

            switch (choice) {
                case 1 -> loginMenu();
                case 2 -> registerMenu();
                case 3 -> {
                    System.out.println("Thank you for using NOVAREAD!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // =============== REGISTER ===============
    private void registerMenu() {
        System.out.println("\n--- Register ---");

        System.out.print("Create Username: ");
        String username = sc.nextLine();

        if (readerList.exists(username)) {
            System.out.println("Username already exists!");
            return;
        }

        System.out.print("Create Password: ");
        String password = sc.nextLine();

        readerList.addReader(username, password);
        System.out.println("Register successful!");
    }

    // =============== LOGIN ===============
    private void loginMenu() {
        System.out.println("\n--- Login ---");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        Reader user = readerList.login(username, password);

        if (user == null) {
            System.out.println("Login failed!");
            return;
        }

        System.out.println("Welcome, " + user.username + "!");
        userMenu(user);
    }

    // =============== USER MENU (SETELAH LOGIN) ===============
    private void userMenu(Reader user) {
        int option;

        while (true) {
            System.out.println("\n====== USER MENU ======");
            System.out.println("1. Show All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Add Book to Favorites");
            System.out.println("4. Show My Library");
            System.out.println("5. Logout");
            System.out.print("Choose: ");
            option = getInt();

            switch (option) {
                case 1 -> bookDB.printAllDatabase();

                case 2 -> {
                    searchMenu();
                }

                case 3 -> addFavorite(user);

                case 4 -> {
                    System.out.println("=== Your Favorite Books ===");
                    user.favorites.printFavorite();
                }

                case 5 -> {
                    System.out.println("Logged out.");
                    return;
                }

                default -> System.out.println("Invalid option!");
            }
        }
    }

    // =============== SEARCH BOOKS ===============
    private void searchMenu() {
        System.out.println("\n=== SEARCH BOOK ===");
        System.out.println("1. Search by Title");
        System.out.println("2. Search by Author");
        System.out.println("3. Search by Genre");
        System.out.println("4. Search by Tag");
        System.out.println("5. Back");
        System.out.print("Choose: ");

        int opt = getInt();

        DoublyLinkedList list = bookDB.allBooks; // supaya singkat

        switch (opt) {
            case 1 -> {
                System.out.print("Enter title keyword: ");
                String key = sc.nextLine();
                searching.searchByTitle(list, key);
            }
            case 2 -> {
                System.out.print("Enter author name: ");
                String key = sc.nextLine();
                searching.searchByAuthor(list, key);
            }
            case 3 -> {
                System.out.print("Enter genre: ");
                String key = sc.nextLine();
                searching.searchByGenre(list, key);
            }
            case 4 -> {
                System.out.print("Enter tag: ");
                String key = sc.nextLine();
                searching.searchByTag(list, key);
            }
            case 5 -> {
                return;
            }

            default -> System.out.println("Invalid input!");
        }
    }

    // =============== ADD FAVORITE BOOK ===============
    private void addFavorite(Reader user) {
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        // cari buku berdasarkan title
        Book book = bookDB.searchOneByTitle(title);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        // Panggil method dari Favorite.java
        user.favorites.addFavorite(book);
    }

    // =============== SAFE INTEGER INPUT ===============
    private int getInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine(); // clear buffer
        return val;
    }
}
