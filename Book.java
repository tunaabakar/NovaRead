public class Book {
    int id;
    String title;
    String author;
    String genre;
    String sinopsis;
    String tahunTerbit;
    double rating;

    public Book(int id, String title, String author, String genre, String sinopsis, String tahunTerbit, double rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.tahunTerbit = tahunTerbit;
        this.sinopsis = sinopsis;
        this.rating = rating;
    }
}
/*
 * ==========================================
 * CLASS: Book
 * ==========================================
 * Fungsi: 
 * Ini adalah "Blueprint" atau node utama data kita.
 * Class ini cuma buat nyimpen properti buku (Judul, ID, Rating, dll).
 * Isinya cuma data mentah.
 * ==========================================
 */