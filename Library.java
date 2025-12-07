public class Library {
    DoubleLinkedList bookList;
    Tree genreTree;
    LibraryFavorite favorites;

    public Library() {
        bookList = new DoubleLinkedList();
        genreTree = new Tree();
        favorites = new LibraryFavorite();
    }

    public void addBook(Book book) {
        bookList.addLast(book);
        if (book.genre != null) {
            genreTree.insertGenre(book.genre);
            genreTree.insertBookToGenre(book.genre, book);
        }
    }

    public void removeBookById(int id) {
        DLLNode current = bookList.getHead();
        while (current != null) {
            if (current.data.id == id) {
                bookList.remove(current.data);
                break;
            }
            current = current.next;
        }
    }

    public void printAllBooks() {
        bookList.displayForward();
    }

    public void sortByTitle() {
        Sorting.sortByTitle(bookList);
    }

    public void sortByRating() {
        Sorting.sortByRating(bookList);
    }

    public void sortByDate() {
        Sorting.sortByDate(bookList);
    }

    public void sortByGenre() {
        Sorting.sortByGenre(bookList);
    }

    public void showGenres() {
        genreTree.displayInOrder();
    }
}
