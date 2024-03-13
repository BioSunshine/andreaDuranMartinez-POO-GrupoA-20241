public class MainMenu {
    public static void main(String[] args) {
    /* Se desea crear un sistema para una librería
    3 clases. Libreria debe contener arraylist libros y arraylist usuarios
    El sistema debe tener una opción para registrar usuarios
    El sistema debe tener una opción para registrar libros
    El sistema debe tener una opción para realizar renta de libro
    Usuario puede rentar uno o muchos libros pero un libro puede ser rentado solo por un usuario
    Opción para listar todos usuarios registrados
    Opcion listar todos libros registrados
    opcion listar todos usuarios que hayan comprado al menos un libro
    opcion listar libros no rentados
    opcion listar libros rentados
    menu usuario pueda interactuar con el y seleccionar las opciones deseadas
     */
        Library.testingInfo();
        boolean band=true;
        do{
            System.out.println("""

                    \t\t\t>>>>>Welcome to the Library<<<<<<

                     \tWhat do you want to do?

                     \t1) Register User
                     \t2) Register a Book
                     \t3) Rent a Book
                     \t4) Return a Book
                     \t5) See the lists 
                     \t0) Exit system""");
            int option= ConsoleReader.sc.nextInt();
            switch (option){
                case 1 -> {ConsoleReader.sc.nextLine();
                            UsersController.createUser();}
                case 2 -> {ConsoleReader.sc.nextLine();
                    Books.registerBook();}
                case 3 -> Library.rentABook();
                case 4 -> Library.returnBook();
                case 5 -> Showlists.menuLists();
                case 0 -> band=false;
                default -> System.out.println("Invalid input...");
            }
        }while(band);
    }
}
