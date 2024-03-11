public class BooksController {
    public static void registerBook (){
        System.out.println("Title : ");
        String title = ConsoleReader.sc.nextLine();
        System.out.println("Author : ");
        String author = ConsoleReader.sc.nextLine();
        if (title.isEmpty()&&author.isEmpty()){
            System.out.println("Invalid input, please introduce correctly the data");
            return;
        }
        System.out.println("Publication year : ");
        int year = ConsoleReader.sc.nextInt();
        if(year>2024){
            System.out.println("Invalid input, please verify");
            return;
        }
        long id= IdGenerator.createBookId();
        Books newBook = new Books(id, title, author, year );
        Library.addBook(newBook);
    }
}
