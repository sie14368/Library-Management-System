import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n-------------------------");
            System.out.println("\nLIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Register Student");
            System.out.println("4. Register Faculty");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Display Transactions");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        System.out.print("Enter ISBN: ");
                        String isbn = sc.nextLine();

                        System.out.print("Enter Category: ");
                        String category = sc.nextLine();

                        System.out.print("Enter Publication Year: ");
                        int year = sc.nextInt();
                        sc.nextLine();

                        Book book = new Book(title, author, isbn, category, year);

                        library.addBook(book);

                        break;

                    case 2:

                        library.displayBooks();

                        break;

                    case 3:

                        System.out.print("Enter Student ID: ");
                        int studentId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String studentName = sc.nextLine();

                        library.addUser(new Student(studentId, studentName));

                        break;

                    case 4:

                        System.out.print("Enter Faculty ID: ");
                        int facultyId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Faculty Name: ");
                        String facultyName = sc.nextLine();

                        library.addUser(new Faculty(facultyId, facultyName));

                        break;

                    case 5:

                        System.out.print("Enter ISBN: ");
                        isbn = sc.nextLine();

                        System.out.print("Enter User ID: ");
                        int issueUser = sc.nextInt();
                        sc.nextLine();

                        library.issueBook(isbn, issueUser);

                        break;

                    case 6:

                        System.out.print("Enter ISBN: ");
                        isbn = sc.nextLine();

                        System.out.print("Enter User ID: ");
                        int returnUser = sc.nextInt();
                        sc.nextLine();

                        library.returnBook(isbn, returnUser);

                        break;

                    case 7:

                        System.out.print("Enter ISBN: ");
                        isbn = sc.nextLine();

                        library.removeBook(isbn);

                        break;

                    case 8:

                        library.displayTransactions();

                        break;

                    case 9:

                        System.out.println("Thank you for using Library Management System!");

                        break;

                    default:

                        System.out.println("Invalid Choice!");

                }

            } catch (BookNotFoundException | BookAlreadyIssuedException e) {

                System.out.println(e.getMessage());

            } catch (Exception e) {

                System.out.println("Something went wrong!");

            }

        } while (choice != 9);

        sc.close();

    }

}