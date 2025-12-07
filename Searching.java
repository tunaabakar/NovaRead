public class Searching {
    public static void searchByTitle(DoubleLinkedList list, String keyword) {
        System.out.println("\n🔍 Hasil Pencarian Judul: " + keyword);
        DLLNode current = list.head;
        boolean found = false;
        while (current != null) {
            if (current.data.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(current.data);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("   Tidak ditemukan.");
    }
}

/*
     * ======================================================
     * METHOD: Searching (Pencarian)
     * ======================================================
     * Fungsi:
     * Menemukan data spesifik di dalam tumpukan/list buku.
     * * Logika:
     * Melakukan traversal (penelusuran) dari data pertama,
     * mengecek apakah data cocok dengan "Key" yang dicari.
     * Jika ketemu -> Return datanya.
     * Jika sampai ujung tidak ketemu -> Return null/not found.
     * ======================================================
     */