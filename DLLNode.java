public class DLLNode {
    Book data;
    DLLNode prev;
    DLLNode next;

    public DLLNode(Book data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
/*
 * ==========================================
 * CLASS: DLLNode (Doubly Linked List Node)
 * ==========================================
 * Fungsi:
 * Ini adalah "Wadah" untuk buku saat masuk ke Library utama.
 * 1. prev -> menunjuk ke buku sebelumnya.
 * 2. next -> menunjuk ke buku selanjutnya.
 * Biar kita bisa jalan maju-mundur di daftar buku.
 * ==========================================
 */