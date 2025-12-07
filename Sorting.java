public class Sorting {
    public static void sortByRating(DoubleLinkedList list) {
        if (list.head == null) return;
        boolean swapped;
        do {
            swapped = false;
            DLLNode current = list.head;
            while (current.next != null) {
                if (current.data.rating < current.next.data.rating) {
                    Book temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> List diurutkan berdasarkan Rating (Tertinggi).");
    }

    public static void sortByTitle(DoubleLinkedList list) {
        if (list.head == null) return;
        boolean swapped;
        do {
            swapped = false;
            DLLNode current = list.head;
            while (current.next != null) {
                if (current.data.title.compareToIgnoreCase(current.next.data.title) > 0) {
                    Book temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> List diurutkan berdasarkan Judul (A-Z).");
    }
}

/*
     * ======================================================
     * METHOD: Sorting (Pengurutan)
     * ======================================================
     * Fungsi:
     * Mengatur ulang urutan node/data buku agar rapi.
     * * Logika:
     * Membandingkan satu buku dengan buku lainnya (Compare),
     * lalu menukar posisinya (Swap) jika urutannya salah
     * sampai semua data terurut (Ascending/Descending).
     * ======================================================
     */