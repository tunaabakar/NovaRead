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

    
    public String formatDisplay() {
        StringBuilder sb = new StringBuilder();

        sb.append(title).append(" - ").append(author).append("\n");
        sb.append("    Genre  : ").append(genre).append("\n");
        sb.append("    Rating : ").append(String.format("%.1f", rating)).append("\n");
        sb.append("    Tag    : ").append(tag).append("\n");
        sb.append("    Last   : ").append(lastDate);

        return sb.toString();
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }
}
