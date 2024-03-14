import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainMenu {
    public static void main(String[] args) {
        Library library = new Library();
        library.testingInfo();
        boolean band=true;
        do{
            System.out.println("""

                    \t\t\t>>>>>Welcome to the Library<<<<<<

                     \tWhat do you want to do?

                     \t1) Register User
                     \t2) Register a Book
                     \t3) Rent a Book
                     \t4) Return a Book
                     \t5) Buy a Book
                     \t6) See registered Users
                     \t7)See users that have rented a least a Book\s
                     \t8)See All the Books
                     \t9)See Books available
                     \t10)See rented books
                     \t11)See users that have bought a book\s
                     \t0) Exit system""");
            Scanner sc = new Scanner(System.in);
            int option= sc.nextInt();
            switch (option){
                case 1 -> library.createUser();
                case 2 -> library.registerBook();
                case 3 -> library.rentABook();
                case 4 -> library.returnBook();
                case 5 -> library.buyABook();
                case 6 -> {library.showUsers();}
                case 7 -> {library.showUsersHaveRentedBooks();}
                case 8 -> {library.showAllBooks();}
                case 9 -> {library.showBooksAvailable();}
                case 10 -> {library.showRentedBooks();}
                case 11 -> {library.showUserWithRentedBooks();}
                case 0 -> band=false;
                default -> System.out.println("Invalid input...");
            }
        }while(band);
    }

}
