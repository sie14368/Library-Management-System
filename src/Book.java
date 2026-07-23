public class Book {

    private String title;
    private String author;
    private String isbn;
    private String category;
    private int publicationYear;
    private boolean issued;

    public Book(String title, String author, String isbn, String category, int publicationYear) {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.publicationYear = publicationYear;
        this.issued = false;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategory() {
        return category;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isIssued() {
        return issued;
    }

    // Setter
    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    // Display Book Details
    @Override
    public String toString() {
        return "\nTitle : " + title +
                "\nAuthor : " + author +
                "\nISBN : " + isbn +
                "\nCategory : " + category +
                "\nPublication Year : " + publicationYear +
                "\nStatus : " + (issued ? "Issued" : "Available");
    }
}