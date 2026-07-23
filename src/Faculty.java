public class Faculty extends User {

    public Faculty(int userId, String name) {
        super(userId, name);
    }

    @Override
    public int getBorrowLimit() {
        return 7;
    }
}