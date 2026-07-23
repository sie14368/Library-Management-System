import java.time.LocalDate;

public class Transaction {

    private Book book;
    private User user;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction(Book book, User user) {
        this.book = book;
        this.user = user;
        issueDate = LocalDate.now();
    }

    public void returnBook() {
        returnDate = LocalDate.now();
    }

    @Override
    public String toString() {

        return user.getName()
                + " borrowed "
                + book.getTitle()
                + " on "
                + issueDate
                + " Returned: "
                + returnDate;
    }
}