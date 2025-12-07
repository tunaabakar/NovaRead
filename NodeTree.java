class NodeTree {
    String genre;
    DoubleLinkedList books;
    NodeTree left;
    NodeTree right;

    public NodeTree(String genre) {
        this.genre = genre;
        this.books = new DoubleLinkedList();
        this.left = null;
        this.right = null;
    }
}
