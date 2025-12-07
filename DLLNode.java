class DLLNode {
    Book data;
    DLLNode prev;
    DLLNode next;

    public DLLNode(Book data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
