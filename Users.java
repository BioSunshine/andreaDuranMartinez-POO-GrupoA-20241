import java.util.ArrayList;

public class Users {
    private String id;
    private String name;
    private String lastname;
    private int age;
    private ArrayList<Books> listRentedBooks = new ArrayList<>();
    private boolean hasRentedBook;
    private boolean hasBoughtABook; //comprado un libro

    public Users(String id, String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname =lastname;
        this.age = age;
    }

    public String getLastname() {
        return lastname;
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

    public ArrayList<Books> getListRentedBooks() {
        return listRentedBooks;
    }

    public void rentABook (Books newBook){
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
        Books bookSelected = listRentedBooks.get(selection);
        bookSelected.setItsAvailable(true);
        listRentedBooks.remove(selection);
        System.out.println("The book has been returned");

    }




}
