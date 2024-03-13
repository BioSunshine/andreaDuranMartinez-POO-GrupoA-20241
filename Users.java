import java.util.ArrayList;

public class Users {
    private String id;
    private String name;
    private String lastname;
    private int age;
    private static ArrayList<Books> listRentedBooks = new ArrayList<>();
    private boolean hasRentedBook;
    private int timesRented;

    public Users(String id, String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname =lastname;
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void setListRentedBooks(ArrayList<Books> listRentedBooks) {
        Users.listRentedBooks = listRentedBooks;
    }

    public boolean isHasRentedBook() {
        return hasRentedBook;
    }

    public void setHasRentedBook(boolean hasRentedBook) {
        this.hasRentedBook = hasRentedBook;
    }

    public int getTimesRented() {
        return timesRented;
    }

    public void setTimesRented(int timesRented) {
        this.timesRented = timesRented;
    }

    public ArrayList<Books> getListRentedBooks() {
        return listRentedBooks;
    }

    public static void rentABook (Books newBook){
        listRentedBooks.add(newBook);
    }

    public void returnBook(){
        System.out.println("Select the book the client wants to return");
        int count=0;
        for(Books book : listRentedBooks){
            System.out.println("| ID " + (count + 1) + " Id: " +  book.getId()+" Title: " + book.getTitle() + " Author: " + book.getAuthor() + " Publication Year: " + book.getYear());
        count++;
        }
        int selection = ConsoleReader.sc.nextInt();
        selection--;
        listRentedBooks.remove(selection);
        Books bookSelected = listRentedBooks.get(selection);
        bookSelected.setItsAvailable(true);
        System.out.println("The book has been returned");

    }


}
