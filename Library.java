import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<User> Userlist = new ArrayList<>();//declarar arreglo
    private ArrayList<Book> Booklist = new ArrayList<>();

    public Library() {
    }

    // CREATE USER
    public void createUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce the name: ");
        String name = sc.nextLine();
        System.out.println("Introduce the lastname: ");
        String lastname = sc.nextLine();

        //tiene que haber validación
        if (name.isEmpty() && lastname.isEmpty()) {
            System.out.println("Input invalid...");

        } else {
            System.out.println("Introduce the age");
            int age = sc.nextInt();
            if (age < 6) {
                System.out.println("Not possible to register with that age ");
                return;
            }
            IdGenerator IdGenerator = new IdGenerator();
            String id = IdGenerator.createId();
            User newUser = new User(id, name, lastname, age);
            Userlist.add(newUser);
            System.out.println("User created successfully");
        }
    }
    // REGISTER BOOK
    public void registerBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Title : ");
        String title = sc.nextLine();
        System.out.println("Author : ");
        String author = sc.nextLine();
        if (title.isEmpty()&&author.isEmpty()){
            System.out.println("Invalid input, please introduce correctly the data");
            return;
        }
        System.out.println("Publication year : ");
        int year = sc.nextInt();
        if(year>2024){
            System.out.println("Invalid input, please verify");
            return;
        }
        IdGenerator genID = new IdGenerator();
        String id= genID.createBookId();
        Book newBook = new Book(id, title, author, year,true );
        Booklist.add(newBook);
        System.out.println("Book registered succesfully");
    }
    //RENT A BOOK
    public void rentABook(){
        Scanner sc = new Scanner(System.in);
        //listar clientes y seleccionar uno
        System.out.println("Select the client who wants to rent a Book");
        showUsers();
        int option = sc.nextInt();
        option--;
        User Userelected = Userlist.get(option);
        System.out.println("You choosed: "+ " code: "+Userelected.getId()+" | Name: "+Userelected.getName()+" | Lastname: "+Userelected.getLastname()+" | Age: "+Userelected.getAge());
        ////////////////////////////
        System.out.println("Choose the book the client wants to rent: ");
        int id = 0;
        //bookid, title, author, year
        //mostrar solo titulos disponibles
        for(Book book : Booklist){ //objeto loquesea : lista
            if(book.isItsAvailable()) {
                System.out.println("| ID " + (id + 1) + " Id: " + book.getId() + " Title: " + book.getTitle() + " Author: " + book.getAuthor() + " Publication Year: " + book.getYear());
            }
            id++;
        }
        int selection = sc.nextInt();
        selection--;
        //Hasta aquí ya eligió el libro
        Book bookselected = Booklist.get(selection);
        if(!bookselected.isItsAvailable()){
            System.out.println("Sorry, that book isn't available, even it is not shown in the list");
            return;
        }
        System.out.println("You selected:\n  Title: "+bookselected.getTitle()+" | Author: "+bookselected.getAuthor());
        //Userelected.getListRentedBooks().add(bookselected); //Se agrega libro a la lista personal del usuario
        Userlist.get(option).rentABook(bookselected);
        Userlist.get(option).setHasRentedBook(true);
        Booklist.get(selection).setItsAvailable(false); //aquí cambio a que ya no esta disponible
        System.out.println(" >>>Now the rent is authorized \n > The client can take the book ");
    }
    //RETURN BOOK
    public void returnBook(){//si tengo uno para rentar tengo que hacer uno para devolver y que el libro vuelva a estar disponible
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the client who wants to return a book");
        //antes de que sigas escribe aparte el método para mostrar usuarios(encierra el case 2 de showlists e invocalo en este y en el rentabook))
        showUsersHaveRentedBooks();
        int input = sc.nextInt();
        input--;
        User Userelected = Userlist.get(input);
        System.out.println("Which book wants to return?");
        //mostrar lista de libros del ussuario
        seeRentedBooks(Userelected);
    }
    //SEE RETURN BOOKS
    public void seeRentedBooks(User selectedUser){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the book the client wants to return");
        int count=0;
        for(Book book :selectedUser.getListRentedBooks() ){
            System.out.println("| ID " + (count + 1) + " Id: " +  book.getId()+" Title: " + book.getTitle() + " Author: " + book.getAuthor() + " Publication Year: " + book.getYear());
            count++;
        }
        int selection = sc.nextInt();
        selection--;
        Book bookSelected = selectedUser.getListRentedBooks().get(selection);
        bookSelected.setItsAvailable(true);
        selectedUser.getListRentedBooks().remove(selection);
        System.out.println("The book has been returned");

    }
    //BUY A BOOK
    public void buyABook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the client who wants to buy a Book: ");
        int ID = 0;
        for (User user : Userlist){ //tipoobjeto loquesea: lista
            System.out.println("| ID: "+ (ID+1)+" | code: "+user.getId()+" | Name: "+user.getName()+" | Lastname: "+user.getLastname()+" | Age: "+user.getAge());
            ID++;
        }
        int selection = sc.nextInt();
        selection--;
        User Userelected= Userlist.get(selection);
        System.out.println("Select the book the client wants to buy: ");
        showBooksAvailable();
        int input = sc.nextInt();
        input --;
        Book bookSelected = Booklist.get(input);
        if(!bookSelected.isItsAvailable()){
            System.out.println("Sorry, that book isn't available, even it is not shown in the list");
            return;
        }
        System.out.println("Enter the price: ");
        double price = sc.nextDouble();
        if (price<0){
            System.out.println("Invalid value");
            return;
        }
        System.out.println("The user "+Userelected.getName()+"  "+Userelected.getLastname()+" has bought "+bookSelected.getTitle()+" by $ "+price);

        bookSelected.setItsAvailable(false);
        Userelected.setHasBoughtABook(true);
        Booklist.remove(input);

    }
    //SHOW USER
    public void showUsers (){
        int ID = 0;
        for (User user : Userlist){ //tipoobjeto loquesea: lista
            System.out.println("| ID: "+ (ID+1)+" | code: "+user.getId()+" | Name: "+user.getName()+" | Lastname: "+user.getLastname()+" | Age: "+user.getAge());
            ID++;
        }
    }
    //SHOW USER THAT HAVE RENTED BOOKS
    public void showUsersHaveRentedBooks() {
        int ID = 0;
        for (User user : Userlist) {
            if (user.isHasRentedBook()) {
                System.out.println("|ID: " + (ID + 1) + " | code: " + user.getId() + " | Name: " + user.getName() + " | Lastname: " + user.getLastname() + " | Age: " + user.getAge());
            }
            ID++;
        }
    }
    //SEE ALL BOOKS
    public void showAllBooks(){
        int ID=0;
        for(Book book : Booklist){
            System.out.println(" | ID: "+(ID+1)+" | code: "+book.getId()+" | Title: "+book.getTitle()+" | Author: "+book.getAuthor()+" | Publication year: "+book.getYear());
            ID++;
        }
    }
    //ALL AVAILABLE BOOKS
    public void showBooksAvailable() {
        int ID = 0;
        for (Book availables : Booklist) {
            if (availables.isItsAvailable()) {
                System.out.println("|ID: " + (ID + 1) + " | code: " + availables.getId() + " | Title: " + availables.getTitle() + " | Author: " + availables.getAuthor() + " | Publication year: " + availables.getYear());
            }
            ID++;
        }
    }
    //ALL RENTED BOOKS
    public void showRentedBooks(){
        int ID=0;
        for(Book rentedBooks : Booklist){
            if (!rentedBooks.isItsAvailable()){
                System.out.println("|ID: "+(ID+1)+" | code: "+rentedBooks.getId()+" | Title: "+rentedBooks.getTitle()+"| Author: "+rentedBooks.getAuthor()+" | Publication year: "+rentedBooks.getYear());
            }
            ID++;
        }
    }
    //User THAT HAVE BOUGHT BOOKS
    public void showUserWithRentedBooks(){
        int ID =0;
        for (User user : Userlist){
            if(user.isHasBoughtABook()){
                System.out.println("|ID: "+(ID+1)+" | code: "+user.getId()+" | Name: "+user.getName()+" | Lastname: "+user.getLastname()+ " | Age: "+user.getAge());
            }
            ID++;
        }
    }
    //TEST INFO
    public void testingInfo(){
        ///User
        IdGenerator IdGenerator = new IdGenerator();
        String Id1 = IdGenerator.createId();
        String Id2 = IdGenerator.createId();
        String Id3 = IdGenerator.createId();
        User user1 = new User(Id1, "Alejandro", "Montejano", 20);
        User user2 = new User(Id2, "Atziri", "Mancilla", 27);
        User user3 = new User(Id3, "Jafet", "Santoyo", 27);
        Userlist.add(user1);
        Userlist.add(user2);
        Userlist.add(user3);

        /////Books
        String IdB1 = IdGenerator.createBookId();
        String IdB2 = IdGenerator.createBookId();
        String IdB3 = IdGenerator.createBookId();
        String IdB4 = IdGenerator.createBookId();
        String IdB5 = IdGenerator.createBookId();
        String IdB6 = IdGenerator.createBookId();
        Book book1 = new Book(IdB1, "Muerte en el Nilo", "Agatha Chriestie", 1937,true);
        Book book2 = new Book(IdB2, "Las memorias de Sherlock Holmes", "Arthur Conan Doyle", 1894,true);
        Book book3 = new Book(IdB3, "El pulgar del violinista", "Sam Kean", 2013,true);
        Book book4 = new Book(IdB4, "Momo", "Michael Ende", 1972,true);
        Book book5 = new Book(IdB5, "Salvar el fuego", "Guillermo Arriaga", 2020,true);
        Book book6 = new Book(IdB6, "Ilusiones", "Richard Bach", 1977,true);

        Booklist.add(book1);
        Booklist.add(book2);
        Booklist.add(book3);
        Booklist.add(book4);
        Booklist.add(book5);
        Booklist.add(book6);
    }
}

