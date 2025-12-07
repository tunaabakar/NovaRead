public class Favorite {
    Book book;

    public Favorite(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "❤️ " + book.toString();
    }
}
