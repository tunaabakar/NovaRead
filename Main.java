import java.util.Scanner;

public class Main {
        private static void pause() {
                Scanner sc = new Scanner(System.in);
                System.out.print("\nTekan ENTER untuk melanjutkan...");
                sc.nextLine();
        }

    public static void main(String[] args) {

       
        //HEADER
        System.out.println("============================================================");
        System.out.println("                 INITIALIZING NOVAREAD");
        System.out.println("============================================================");
        System.out.println();

        //INISIALISASI DATABASE BUKU & DAFTAR PEMBACA
        BookDatabase bookDB = new BookDatabase();
        ReaderList readerList = new ReaderList();
        Searching searching = new Searching();
        Tree tree = new Tree();

        Book b1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 4.5,
                "Roaring Twenties, American Novel", "A story of the wealthy Jay Gatsby...", "2023-10-01");
        Book b2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 4.7,
                "Southern Gothic, Bildungsroman", "A novel about major social issues...", "2023-11-15");
        Book b3 = new Book(3, "Sapiens", "Yuval Noah Harari", "Non-Fiction", 4.6,
                "Science, History", "A brief history of humankind...", "2023-12-01");
        Book b4 = new Book(4, "1984", "George Orwell", "Dystopian", 4.4,
                "Dystopian, Politics", "A story set in a dystopian future...", "2023-09-20");
        Book b5 = new Book(5, "Pride and Prejudice", "Jane Austen", "Romance", 4.3,
                "Romance, Satire", "A romance novel of manners...", "2023-08-05");
        Book b6 = new Book(6, "Hitchhiker's Guide", "Douglas Adams", "Sci-Fi", 4.2,
                "Comedy, Sci-Fi", "A comedic sci-fi journey...", "2023-11-25");
        Book b7 = new Book(7, "A Brief History of Time", "Stephen Hawking", "Science", 4.8,
                "Physics, Space", "Cosmology explained...", "2023-12-10");
        Book b8 = new Book(8, "Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 4.9,
                "Epic Fantasy", "An epic high fantasy novel...", "2023-07-28");
        Book b9 = new Book(9, "Harry Potter 1", "J.K. Rowling", "Fantasy", 4.6,
                "Magic, Adventure", "The magical journey begins...", "2023-12-05");
        Book b10 = new Book(10, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 4.8,
                "Adventure, Epic Fantasy", "A hobbit embarks on an unexpected journey...", "2023-10-12");
        Book b11 = new Book(11, "The Notebook", "Nicholas Sparks", "Romance", 4.4,
                "Love, Drama", "A touching love story spanning decades...", "2023-11-03");
        Book b12 = new Book(12, "Dune", "Frank Herbert", "Sci-Fi", 4.7,
                "Space, Politics", "A struggle for control of the desert planet Arrakis...", "2023-12-21");
        Book b13 = new Book(13, "The Shining", "Stephen King", "Horror", 4.5,
                "Haunted Hotel, Psychological Horror", "A family faces terror in a remote hotel...", "2023-09-29");
        Book b14 = new Book(14, "Norwegian Wood", "Haruki Murakami", "Slice of Life", 4.3,
                "Youth, Melancholy", "A nostalgic story about love and loss...", "2023-10-18");
        Book b15 = new Book(15, "The Kite Runner", "Khaled Hosseini", "Drama", 4.6,
                "Friendship, Conflict", "A dramatic tale of guilt, betrayal, and redemption...", "2023-12-08");
        Book b16 = new Book(16, "Moby Dick", "Herman Melville", "Classic", 4.2,
                "Adventure, Sea", "A captain obsessively hunts a giant white whale...", "2023-11-11");
        Book b17 = new Book(17, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "Non-Fiction", 4.7,
                "History, Humanity", "A deep exploration of the human species...", "2023-12-15");
        Book b18 = new Book(18, "Omnicients Reader Viewpoint's", "Sing Sho", "Fantasy", 5.0,
                "Fantasy, Adventure, Kultivasi, Tragedy", "“Cuma Aku yang tahu akhir dari dunia ini.”", "2021-01-06");

        bookDB.addBookToDatabase(b1);
        bookDB.addBookToDatabase(b2);
        bookDB.addBookToDatabase(b3);
        bookDB.addBookToDatabase(b4);
        bookDB.addBookToDatabase(b5);
        bookDB.addBookToDatabase(b6);
        bookDB.addBookToDatabase(b7);
        bookDB.addBookToDatabase(b8);
        bookDB.addBookToDatabase(b9);
        bookDB.addBookToDatabase(b10);
        bookDB.addBookToDatabase(b11);
        bookDB.addBookToDatabase(b12);
        bookDB.addBookToDatabase(b13);
        bookDB.addBookToDatabase(b14);
        bookDB.addBookToDatabase(b15);
        bookDB.addBookToDatabase(b16);
        bookDB.addBookToDatabase(b17);
        bookDB.addBookToDatabase(b18);


        tree.insertBookToGenre(b1.genre, b1);
        tree.insertBookToGenre(b2.genre, b2);
        tree.insertBookToGenre(b3.genre, b3);
        tree.insertBookToGenre(b4.genre, b4);
        tree.insertBookToGenre(b5.genre, b5);
        tree.insertBookToGenre(b6.genre, b6);
        tree.insertBookToGenre(b7.genre, b7);
        tree.insertBookToGenre(b8.genre, b8);
        tree.insertBookToGenre(b9.genre, b9);
        tree.insertBookToGenre(b10.genre, b10);
        tree.insertBookToGenre(b11.genre, b11);
        tree.insertBookToGenre(b12.genre, b12);
        tree.insertBookToGenre(b13.genre, b13);
        tree.insertBookToGenre(b14.genre, b14);
        tree.insertBookToGenre(b15.genre, b15);
        tree.insertBookToGenre(b16.genre, b16);
        tree.insertBookToGenre(b17.genre, b17);
        tree.insertBookToGenre(b18.genre, b18);

        // MANUAL POPULASI DATA PEMBACA (ReaderList)
        readerList.addReader("alice", "pass123");
        readerList.addReader("bob", "password");
        readerList.addReader("admin", "admin123");
        pause();

        // =========================================================
        // (OPSI) DEMO ALICE — TIDAK DIJALANKAN
        // =========================================================
        /*
        Reader alice = readerList.login("alice", "pass123");
        if (alice != null) {
            alice.library = new Library();
            alice.readingStack = new Stack();
            alice.history = new Queue();
            alice.readingList = new DoublyLinkedList();
            alice.favorites = new Favorite();

            alice.addToLibrary(book1);
            alice.addToLibrary(book3);
            alice.favorites.addFavorite(book1);
            alice.addToReadingList(book4);
            alice.readNextBook();
        }
        */

        // =========================================================
        // 4. MASUK KE MAIN MENU
        // =========================================================
        System.out.println();
        System.out.println("============================================================");
        System.out.println("                      ENTERING MAIN MENU");
        System.out.println("============================================================");
        System.out.println();

        MainMenu menu = new MainMenu(readerList, bookDB, searching, tree);
        menu.start();

        
    }
}
