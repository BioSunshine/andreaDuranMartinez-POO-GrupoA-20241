import java.util.ArrayList;

public class User {

    private String id;
    private String name;
    private String lastname;
    private int age;
    private ArrayList<Book> listRentedBooks = new ArrayList<>();
    private boolean hasRentedBook;
    private boolean hasBoughtABook;

    public User(String id, String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname =lastname;
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }
    public boolean isHasBoughtABook() {
        return hasBoughtABook;
    }

    public void setHasBoughtABook(boolean hasBoughtABook) {
        this.hasBoughtABook = hasBoughtABook;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public boolean isHasRentedBook() {
        return hasRentedBook;
    }

    public void setHasRentedBook(boolean hasRentedBook) {
        this.hasRentedBook = hasRentedBook;
    }

    public ArrayList<Book> getListRentedBooks() {
        return listRentedBooks;
    }

    public void rentABook (Book newBook){
        listRentedBooks.add(newBook);
    }
}
