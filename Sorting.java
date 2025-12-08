public class Sorting {
    
    /*
     * --------------------------------------------------------
     * Method: sortByTitle()
     * --------------------------------------------------------
     * Mengurutkan buku berdasarkan ABJAD (Ascending).
     */
    public static void sortByTitle(Book head) {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Book current = head;
            while (current.next != null) {
                if (current.title.compareToIgnoreCase(current.next.title) > 0) {
                    swapData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> Berhasil diurutkan berdasarkan Judul (A-Z).");
    }

    /*
     * --------------------------------------------------------
     * Method: sortByRating()
     * --------------------------------------------------------
     * Mengurutkan buku berdasarkan RATING (Descending).
     */
    public static void sortByRating(Book head) {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Book current = head;
            while (current.next != null) {
                if (current.rating < current.next.rating) {
                    swapData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> Berhasil diurutkan berdasarkan Rating (Tinggi ke Rendah).");
    }

    /*
     * --------------------------------------------------------
     * Method: sortByDate()
     * --------------------------------------------------------
     * Mengurutkan buku berdasarkan TANGGAL (Newest).
     */
    public static void sortByDate(Book head) {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Book current = head;
            while (current.next != null) {
                if (current.date.compareTo(current.next.date) < 0) {
                    swapData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> Berhasil diurutkan berdasarkan Tanggal (Terbaru).");
    }

    /*
     * --------------------------------------------------------
     * Method: sortByGenre()
     * --------------------------------------------------------
     * Mengelompokkan buku berdasarkan GENRE (Ascending).
     */
    public static void sortByGenre(Book head) {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Book current = head;
            while (current.next != null) {
                if (current.genre.compareToIgnoreCase(current.next.genre) > 0) {
                    swapData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> Berhasil dikelompokkan berdasarkan Genre.");
    }

    // Helper: Menukar isi data antar dua node
    private static void swapData(Book a, Book b) {
        int tempId = a.id; String tempTitle = a.title; String tempAuthor = a.author;
        String tempGenre = a.genre; double tempRating = a.rating; 
        String tempDate = a.date; String tempTags = a.tags;

        a.id = b.id; a.title = b.title; a.author = b.author;
        a.genre = b.genre; a.rating = b.rating;
        a.date = b.date; a.tags = b.tags;

        b.id = tempId; b.title = tempTitle; b.author = tempAuthor;
        b.genre = tempGenre; b.rating = tempRating;
        b.date = tempDate; b.tags = tempTags;
    }
}

/*
 * ============================================================
 * CLASS: Sorting (Pengurutan Data)
 * ============================================================
 * Fungsi:
 * Mengatur ulang urutan buku (Node) agar rapi.
 * Menggunakan algoritma Bubble Sort sederhana (Swap Data).
 * ============================================================
 */