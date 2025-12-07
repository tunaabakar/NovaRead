public class Book {
    int id;
    String title;
    String author;
    String genre;
    double rating;
    String tag;
    String desc;
    String lastDate; // misal: "2025-12-07"

    public Book(int id, String title, String author, String genre,
                double rating, String tag, String desc, String lastDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.tag = tag;
        this.desc = desc;
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " - " + author +
               " | Genre: " + genre +
               " | Rating: " + rating +
               " | Tag: " + tag +
               " | Last Read: " + lastDate;
    }
}
