public class Searching {

    // Mencari berdasarkan dari title atau judul
    public void searchByTitle(DoublyLinkedList list, String keyword) {
        if (list == null)
            return;

        DoublyLinkedList current = list.getHead();
        System.out.println("\n>> Mencari Judul mengandung: '" + keyword + "'");
        boolean found = false;

        while (current != null) {
            Book b = current.data;
            String title = b.title == null ? "" : b.title;

            if (title.toLowerCase().contains(keyword.toLowerCase())) {
                printResult(b);
                found = true;
            }
            current = current.next;
        }

        if (!found)
            System.out.println("   (Tidak ditemukan)");
    }

    // Mencari berdasarkan dari author atau penulis
    public void searchByAuthor(DoublyLinkedList list, String authorName) {
        if (list == null)
            return;

        DoublyLinkedList current = list.getHead();
        System.out.println("\n>> Mencari Penulis: '" + authorName + "'");
        boolean found = false;

        while (current != null) {
            Book b = current.data;

            if (b.author != null && b.author.equalsIgnoreCase(authorName)) {
                printResult(b);
                found = true;
            }
            current = current.next;
        }

        if (!found)
            System.out.println("   (Tidak ditemukan)");
    }

    // Mencari berdasarkan genre
    public void searchByGenre(DoublyLinkedList list, String genre) {
        if (list == null)
            return;

        DoublyLinkedList current = list.getHead();
        System.out.println("\n>> Filter Genre: '" + genre + "'");
        boolean found = false;

        while (current != null) {
            Book b = current.data;

            if (b.genre != null && b.genre.equalsIgnoreCase(genre)) {
                printResult(b);
                found = true;
            }
            current = current.next;
        }

        if (!found)
            System.out.println("   (Tidak ditemukan)");
    }

    // Mencari berdasarkan tag
    public void searchByTag(DoublyLinkedList list, String tag) {
        if (list == null)
            return;

        DoublyLinkedList current = list.getHead();
        System.out.println("\n>> Mencari Tag: '" + tag + "'");
        boolean found = false;

        while (current != null) {
            Book b = current.data;

            if (b.tag != null && b.tag.toLowerCase().contains(tag.toLowerCase())) {
                printResult(b);
                found = true;
            }
            current = current.next;
        }

        if (!found)
            System.out.println("   (Tidak ditemukan)");
    }

    // Output jika buku ditemukan
    private void printResult(Book b) {
        System.out.println("   Found: " + b.title + " (" + b.rating + "/5.0) - " + b.genre);
    }
}
