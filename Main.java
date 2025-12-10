public class Main {
    public static void main(String[] args) {

        // =========================================================
        // 1. INISIALISASI DATABASE BUKU & DAFTAR PEMBACA
        // =========================================================
        BookDatabase bookDB = new BookDatabase();
        ReaderList readerList = new ReaderList();
        Searching searching = new Searching();

        // =========================================================
        // 2. MANUAL POPULASI DATA BUKU (BookDatabase)
        // =========================================================
        System.out.println("Memuat data buku...");

        // Book(id, title, author, genre, rating, tag, desc, lastDate)
        Book book1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 4.5,
                "Roaring Twenties, American Novel", "A story of the wealthy Jay Gatsby...", "2023-10-01");
        Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 4.7,
                "Southern Gothic, Bildungsroman", "A novel about the serious issues of rape and racial inequality...",
                "2023-11-15");
        Book book3 = new Book(3, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "Non-Fiction", 4.6,
                "History, Science, Philosophy", "A brief history of humankind...", "2023-12-01");
        Book book4 = new Book(4, "1984", "George Orwell", "Dystopian", 4.4,
                "Political Fiction, Sci-Fi", "A story set in a dystopian future...", "2023-09-20");
        Book book5 = new Book(5, "Pride and Prejudice", "Jane Austen", "Romance", 4.3,
                "Regency, Satire", "A romantic novel of manners...", "2023-08-05");
        Book book6 = new Book(6, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science Fiction", 4.2,
                "Comedy, Adventure", "A comedic science fiction series...", "2023-11-25");
        Book book7 = new Book(7, "A Brief History of Time", "Stephen Hawking", "Science", 4.8,
                "Cosmology, Physics", "Explaining complex concepts of cosmology...", "2023-12-10");
        Book book8 = new Book(8, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 4.9,
                "High Fantasy, Epic", "An epic high fantasy novel...", "2023-07-28");
        Book book9 = new Book(9, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 4.6,
                "Young Adult, Magic", "The start of the magical journey...", "2023-12-05");

        bookDB.addBookToDatabase(book1);
        bookDB.addBookToDatabase(book2);
        bookDB.addBookToDatabase(book3);
        bookDB.addBookToDatabase(book4);
        bookDB.addBookToDatabase(book5);
        bookDB.addBookToDatabase(book6);
        bookDB.addBookToDatabase(book7);
        bookDB.addBookToDatabase(book8);
        bookDB.addBookToDatabase(book9);

        System.out.println("Data buku berhasil dimuat: " + bookDB.allBooks.size + " buku.");
        // bookDB.printAllDatabase(); // Opsional: untuk melihat semua buku

        // =========================================================
        // 3. MANUAL POPULASI DATA PEMBACA (ReaderList)
        // =========================================================
        System.out.println("Memuat data pembaca...");

        // addReader(username, password)
        readerList.addReader("alice", "pass123");
        readerList.addReader("bob", "password");
        readerList.addReader("novaread_admin", "admin456");

        // Catatan: Jika ingin menambahkan data Reader dengan nama & email, Anda perlu
        // memodifikasi `ReaderList.addReader` atau menambahkan buku ke library
        // secara manual setelah login (yang biasanya dilakukan melalui Menu).

        System.out.println("Data pembaca berhasil dimuat.");

        // Contoh: Ambil reader yang baru dibuat untuk menambahkan data awal (opsional)
        Reader alice = readerList.login("alice", "pass123");
        if (alice != null) {
            alice.addToLibrary(book1); // Alice memiliki "The Great Gatsby"
            alice.addToLibrary(book3); // Alice memiliki "Sapiens"
            alice.favorites.addFavorite(book1); // Alice menjadikan "The Great Gatsby" favorit
            alice.addToReadingList(book4); // Alice mengantri "1984"
            alice.readNextBook(); // Alice membaca dan menyelesaikan "1984" (masuk history)
        }

        // =========================================================
        // 4. MEMULAI APLIKASI
        // =========================================================
        MainMenu menu = new MainMenu(readerList, bookDB, searching);
        menu.start();
    }
}