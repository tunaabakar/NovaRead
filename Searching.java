public class Searching {

    public static Book searchByTitle(DoubleLinkedList list, String title) {
        DLLNode current = list.getHead();
        while (current != null) {
            if (current.data.title.equalsIgnoreCase(title)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public static void searchByAuthor(DoubleLinkedList list, String author) {
        DLLNode current = list.getHead();
        boolean found = false;
        while (current != null) {
            if (current.data.author.equalsIgnoreCase(author)) {
                System.out.println(current.data);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Tidak ada buku dengan author: " + author);
        }
    }

    public static void searchByGenre(DoubleLinkedList list, String genre) {
        DLLNode current = list.getHead();
        boolean found = false;
        while (current != null) {
            if (current.data.genre.equalsIgnoreCase(genre)) {
                System.out.println(current.data);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Tidak ada buku dengan genre: " + genre);
        }
    }

    public static void searchByTag(DoubleLinkedList list, String tag) {
        DLLNode current = list.getHead();
        boolean found = false;
        while (current != null) {
            if (current.data.tag != null &&
                current.data.tag.equalsIgnoreCase(tag)) {
                System.out.println(current.data);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Tidak ada buku dengan tag: " + tag);
        }
    }
}
