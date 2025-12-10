public class Book {
    int id;
    String title;
    String author;
    String genre;
    double rating;
    String tag;
    String desc;
    String lastDate;

    public Book(int id, String title, String author, String genre, double rating, String tag, String desc,
            String lastDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.tag = tag;
        this.desc = desc;
        this.lastDate = lastDate;
    }

    public Book(String title) {
        this.title = title;
    }

    public String toString() {
        return "[" + id + "] " + title + " - " + author +
                " | Genre: " + genre +
                " | Rating: " + rating +
                " | Tag: " + tag +
                " | Last Read: " + lastDate;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

}