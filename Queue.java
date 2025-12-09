public class Queue {
    Book data;
    Queue next;

    public Queue(Book data) {
        this.data = data;
        this.next = null;
    }
}

/*
 * ==========================================
 * CLASS: QueueNode
 * ==========================================
 * Fungsi:
 * Node sederhana khusus untuk fitur Antrian (Queue).
 * Mirip StackNode, tapi dipisah biar kodenya rapi dan jelas mana node buat
 * antriannya sama mana node buat history-nya.
 * ==========================================
 */