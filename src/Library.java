import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private HashMap<Integer, User> users;
    private ArrayList<Transaction> transactions;

    public Library() {
        books = new ArrayList<>();
        users = new HashMap<>();
        transactions = new ArrayList<>();
    }

    //BOOK METHODS

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBook(String isbn) throws BookNotFoundException {

        for (Book book : books) {

            if (book.getIsbn().equals(isbn)) {
                return book;
            }

        }

        throw new BookNotFoundException("Book not found.");

    }

    public void removeBook(String isbn) throws BookNotFoundException {

        Book book = searchBook(isbn);

        books.remove(book);

        System.out.println("Book removed successfully.");

    }

    //USER METHODS

    public void addUser(User user) {

        users.put(user.getUserId(), user);

        System.out.println("User registered successfully.");

    }

    public User searchUser(int id) {

        return users.get(id);

    }

    //ISSUE BOOK

    public void issueBook(String isbn, int userId)
            throws BookNotFoundException, BookAlreadyIssuedException {

        Book book = searchBook(isbn);

        User user = searchUser(userId);

        if (user == null) {

            System.out.println("User not found.");

            return;

        }

        if (book.isIssued()) {

            throw new BookAlreadyIssuedException("Book already issued.");

        }

        if (user.getBorrowedBooks().size() >= user.getBorrowLimit()) {

            System.out.println("Borrow limit exceeded.");

            return;

        }

        book.setIssued(true);

        user.borrowBook(book);

        transactions.add(new Transaction(book, user));

        System.out.println("Book issued successfully.");

    }

    //RETURN BOOK

    public void returnBook(String isbn, int userId)
            throws BookNotFoundException {

        Book book = searchBook(isbn);

        User user = searchUser(userId);

        if (user == null) {

            System.out.println("User not found.");

            return;

        }

        if (!book.isIssued()) {

            System.out.println("Book is already available.");

            return;

        }

        book.setIssued(false);

        user.returnBook(book);

        System.out.println("Book returned successfully.");

    }

    //TRANSACTION HISTORY

    public void displayTransactions() {

        if (transactions.isEmpty()) {

            System.out.println("No transactions found.");

            return;

        }

        for (Transaction transaction : transactions) {

            System.out.println(transaction);

        }

    }

}