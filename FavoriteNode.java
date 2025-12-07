class FavoriteNode {
    Favorite data;
    FavoriteNode prev;
    FavoriteNode next;

    public FavoriteNode(Favorite data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
