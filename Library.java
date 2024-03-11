import java.util.ArrayList;

public class Library {
    private static ArrayList<Users> Userlist = new ArrayList<>();//declarar arreglo
    private static ArrayList<Books> Booklist = new ArrayList<>();

    public static ArrayList<Users> getUserlist() {
        return Userlist;
    }

    public static void setUserlist(ArrayList<Users> userlist) {
        Library.Userlist = userlist;
    }

    public static ArrayList<Books> getBooklist() {
        return Booklist;
    }

    public static void setBooklist(ArrayList<Books> booklist) {
        Library.Booklist = booklist;
    }

    public static void addUser(Users newUser){
        Userlist.add(newUser);
    }
    public static void addBook(Books newBook){
        Booklist.add(newBook);
    }
    public static void rentABook(){
        //listar clientes y seleccionar uno
        System.out.println("Select the client who wants to rent a Book");
        //System.out.printf()
        //%d int %f float y double  %c 'a' %s "hello
        int ID = 0;
        //id name lastname age
        for ( Users user : Userlist){
            System.out.println("| ID "+(ID+1)+ " Id: "+ user.getId()+ " Name: "+user.getName()+" Lastname: "+user.getLastname()+"Age: "+user.getAge());
        }
        int option = ConsoleReader.sc.nextInt();
        option--;
        Users Userselected = Library.getUserlist().get(option);
        System.out.println("You choosed: "+ Userselected.toString());
        ////////////////////////////
        System.out.println("Choose the book the client wants to rent: ");
        int id = 0;
        //bookid, title, author, year
        //mostrar solo titulos disponibles
        ArrayList<Books> availableBooks = new ArrayList<>();
        for(Books book : Booklist){ //objeto loquesea : lista
            if(book.isItsAvailable()==true) {
                System.out.println("| ID " + (id + 1) + " Id: " + book.getId() + " Title: " + book.getTitle() + " Author: " + book.getAuthor() + " Publication Year: " + book.getYear());
            }
            id++;
        }
        int selection = ConsoleReader.sc.nextInt();
        selection--;
        //Hasta aquí ya eligió el libro

        Books bookselected = Booklist.get(selection);
        System.out.println("You selected:  Title: "+bookselected.getTitle()+"Author: "+bookselected.getAuthor());
        Userselected.getListRentedBooks().add(bookselected); //Se agrega libro a la lista personal del usuario
        Userselected.setHasRentedBook(true);
        bookselected.setItsAvailable(false); //aquí cambio a que ya no esta disponible
        System.out.println("Now the rent is authorized \n the client can take the book ");
    }
    public static void returnBook (){//si tengo uno para rentar tengo que hacer uno para devolver y que el libro vuelva a estar disponible

    }
}
