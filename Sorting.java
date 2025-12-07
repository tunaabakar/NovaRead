public class Sorting {

    public static void sortByTitle(DoubleLinkedList list) {
        if (list.size <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            DLLNode current = list.getHead();
            while (current != null && current.next != null) {
                if (current.data.title.compareToIgnoreCase(current.next.data.title) > 0) {
                    Book temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public static void sortByRating(DoubleLinkedList list) {
        if (list.size <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            DLLNode current = list.getHead();
            while (current != null && current.next != null) {
                if (current.data.rating < current.next.data.rating) {
                    Book temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public static void sortByDate(DoubleLinkedList list) {
        if (list.size <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            DLLNode current = list.getHead();
            while (current != null && current.next != null) {
                String d1 = current.data.lastDate;
                String d2 = current.next.data.lastDate;
                if (d1 != null && d2 != null && d1.compareTo(d2) < 0) {
                    Book temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public static void sortByGenre(DoubleLinkedList list) {
        if (list.size <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            DLLNode current = list.getHead();
            while (current != null && current.next != null) {
                if (current.data.genre.compareToIgnoreCase(current.next.data.genre) > 0) {
                    Book temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
