public class Student extends User {

    public Student(int userId, String name) {
        super(userId, name);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}