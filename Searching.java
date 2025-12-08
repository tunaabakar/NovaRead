public class Searching {
    /*
     * --------------------------------------------------------
     * Method: searchByTitle()
     * --------------------------------------------------------
     * Mencari buku yang JUDULNYA mengandung kata kunci.
     */
    public static void searchByTitle(Book head, String keyword) {
        System.out.println("\n>> Mencari Judul mengandung: '" + keyword + "'");
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.toLowerCase().contains(keyword.toLowerCase())) {
                printResult(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("   (Tidak ditemukan)");
    }

    /*
     * --------------------------------------------------------
     * Method: searchByAuthor()
     * --------------------------------------------------------
     * Mencari buku berdasarkan PENULIS.
     */
    public static void searchByAuthor(Book head, String authorName) {
        System.out.println("\n>> Mencari Penulis: '" + authorName + "'");
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.author.equalsIgnoreCase(authorName)) {
                printResult(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("   (Tidak ditemukan)");
    }

    /*
     * --------------------------------------------------------
     * Method: searchByGenre()
     * --------------------------------------------------------
     * Menampilkan semua buku dengan GENRE tertentu.
     */
    public static void searchByGenre(Book head, String genre) {
        System.out.println("\n>> Filter Genre: '" + genre + "'");
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.genre.equalsIgnoreCase(genre)) {
                printResult(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("   (Tidak ditemukan)");
    }

    /*
     * --------------------------------------------------------
     * Method: searchByTag()
     * --------------------------------------------------------
     * Mencari buku yang memiliki TAG spesifik.
     */
    public static void searchByTag(Book head, String tag) {
        System.out.println("\n>> Mencari Tag: '" + tag + "'");
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.tags.toLowerCase().contains(tag.toLowerCase())) {
                printResult(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("   (Tidak ditemukan)");
    }

    // Helper privat untuk print hasil agar rapi
    private static void printResult(Book b) {
        System.out.println("   Found: " + b.title + " (" + b.rating + "/5.0) - " + b.genre);
    }
}
/*
 * ============================================================
 * CLASS: Searching (Pencarian Data)
 * ============================================================
 * Fungsi:
 * Menelusuri Linked List untuk menemukan node yang cocok.
 * Menggunakan Linear Search.
 * ============================================================
 */