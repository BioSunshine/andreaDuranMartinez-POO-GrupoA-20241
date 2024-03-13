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
            System.out.println("| ID "+(ID+1)+ " Id: "+ user.getId()+ " Name: "+user.getName()+" Lastname: "+user.getLastname()+" Age: "+user.getAge());
            ID++;
        }
        int option = ConsoleReader.sc.nextInt();
        option--;
        Users Userselected = Library.getUserlist().get(option);
        System.out.println("You choosed: "+ " code: "+Userselected.getId()+"Name: "+Userselected.getName()+" Lastname: "+Userselected.getLastname()+" Age: "+Userselected.getAge());
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
    public static void returnBook(){//si tengo uno para rentar tengo que hacer uno para devolver y que el libro vuelva a estar disponible
        System.out.println("Select the client who wants to return a book");
        //antes de que sigas escribe aparte el método para mostrar usuarios(encierra el case 2 de showlists e invocalo en este y en el rentabook))
        showUsersHaveRentedBooks();
        int input = ConsoleReader.sc.nextInt();
        input--;
        Users userSelected = Userlist.get(input);
        System.out.println("Which book wants to return?");
        //mostrar lista de libros del ussuario
        userSelected.returnBook();
    }
    public static void showUsersHaveRentedBooks(){
        int ID = 0;
        for (Users user : Library.getUserlist()){ //tipoobjeto loquesea: lista
            if (!user.getListRentedBooks().isEmpty()) {
                System.out.println("| ID: " + (ID + 1) + " | code: " + user.getId() + " | Name: " + user.getName() + " | Lastname: " + user.getLastname() + " | Age: " + user.getAge());
            }
            ID++;
        }
    }
    public static void testingInfo(){
        ///Users
        String Id1 = IdGenerator.createId();
        String Id2 =IdGenerator.createId();
        String Id3 = IdGenerator.createId();
        Users user1 = new Users(Id1, "Alejandro", "Montejano", 20);
        Users user2 = new Users(Id2, "Atziri", "Mancilla", 27);
        Users user3 = new Users(Id3, "Jafet", "Santoyo", 27);
        Library.addUser(user1);
        Library.addUser(user2);
        Library.addUser(user3);
        /////Books
        String IdB1 = IdGenerator.createBookId();
        String IdB2 = IdGenerator.createBookId();
        String IdB3 = IdGenerator.createBookId();
        String IdB4 = IdGenerator.createBookId();
        String IdB5 = IdGenerator.createBookId();
        Books book1 = new Books(IdB1, "Muerte en el Nilo", "Agatha Chriestie", 1937);
        Books book2 = new Books(IdB2, "Las memorias de Sherlock Holmes", "Arthur Conan Doyle", 1894);
        Books book3 = new Books(IdB3, "El pulgar del violinista", "Sam Kean", 2013);
        Books book4 = new Books(IdB4, "Momo", "Michael Ende", 1972);
        Books book5 = new Books(IdB5, "Salvar el fuego", "Guillermo Arriaga", 2020);
        Library.addBook(book1);
        Library.addBook(book2);
        Library.addBook(book3);
        Library.addBook(book4);
        Library.addBook(book5);
    }
}
