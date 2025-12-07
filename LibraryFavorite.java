public class LibraryFavorite {
    FavoriteNode head;
    FavoriteNode tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void addFavorite(Book book) {
        Favorite favorite = new Favorite(book);
        FavoriteNode newNode = new FavoriteNode(favorite);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean removeFavorite(String title) {
        if (isEmpty()) return false;

        FavoriteNode current = head;
        while (current != null) {
            if (current.data.book.title.equalsIgnoreCase(title)) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Favorite findFavorite(String title) {
        FavoriteNode current = head;
        while (current != null) {
            if (current.data.book.title.equalsIgnoreCase(title)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void printFavorite() {
        if (isEmpty()) {
            System.out.println("Belum ada buku favorit.");
            return;
        }
        System.out.println("Daftar Buku Favorit:");
        FavoriteNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
