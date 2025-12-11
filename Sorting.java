public class Sorting {

    // Mengurutkan berdasarkan judul
    public static void sortByTitle(DoublyLinkedList list) {
        if (list == null)
            return;
        DoublyLinkedList head = list.getHead();
        if (head == null)
            return;
        boolean swapped;
        do {
            swapped = false;
            DoublyLinkedList current = head;
            while (current.next != null) {
                String t1 = current.data.title == null ? "" : current.data.title;
                String t2 = current.next.data.title == null ? "" : current.next.data.title;
                if (t1.compareToIgnoreCase(t2) > 0) {
                    Book tmp = current.data;
                    current.data = current.next.data;
                    current.next.data = tmp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> Berhasil diurutkan berdasarkan Judul (A-Z).\\n");
    }

    // Mengurutkan berdasarkan rating
    public static void sortByRating(DoublyLinkedList list) {
        if (list == null)
            return;
        DoublyLinkedList head = list.getHead();
        if (head == null)
            return;
        boolean swapped;
        do {
            swapped = false;
            DoublyLinkedList current = head;
            while (current.next != null) {
                if (current.data.rating < current.next.data.rating) {
                    Book tmp = current.data;
                    current.data = current.next.data;
                    current.next.data = tmp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> Berhasil diurutkan berdasarkan Rating (Tinggi ke Rendah).\\n");
    }

    // Mengurutkan berdasarkan tanggal
    public static void sortByDate(DoublyLinkedList list) {
        if (list == null)
            return;
        DoublyLinkedList head = list.getHead();
        if (head == null)
            return;
        boolean swapped;
        do {
            swapped = false;
            DoublyLinkedList current = head;
            while (current.next != null) {
                String d1 = current.data.lastDate == null ? "" : current.data.lastDate;
                String d2 = current.next.data.lastDate == null ? "" : current.next.data.lastDate;
                if (d1.compareTo(d2) < 0) {
                    Book tmp = current.data;
                    current.data = current.next.data;
                    current.next.data = tmp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> Berhasil diurutkan berdasarkan Tanggal (Terbaru).\\n");
    }

    // Mengurutkan berdasarkan genre
    public static void sortByGenre(DoublyLinkedList list) {
        if (list == null)
            return;
        DoublyLinkedList head = list.getHead();
        if (head == null)
            return;
        boolean swapped;
        do {
            swapped = false;
            DoublyLinkedList current = head;
            while (current.next != null) {
                String g1 = current.data.genre == null ? "" : current.data.genre;
                String g2 = current.next.data.genre == null ? "" : current.next.data.genre;
                if (g1.compareToIgnoreCase(g2) > 0) {
                    Book tmp = current.data;
                    current.data = current.next.data;
                    current.next.data = tmp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println(">> Berhasil dikelompokkan berdasarkan Genre.\\n");
    }

}
