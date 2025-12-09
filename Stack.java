public class Stack {
    Book data;
    Stack next;

    public Stack(Book data) {
        this.data = data;
        this.next = null;
    }
}
/*
 * ==========================================
 * CLASS: StackNode
 * ==========================================
 * Fungsi:
 * Node sederhana khusus untuk fitur History (Stack).
 * Cuma pake pointer 'next' karena di history-nya ntar kita cuma perlu tahu
 * siapa yang ada di bawahnya (klo saya tidak salah mengartikan).
 * ==========================================
 */