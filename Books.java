public class Books {
    private String  id;
    private String title;
    private String author;
    private int year;
    private boolean itsAvailable = true;

    public Books(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
    public static void registerBook(){
        ConsoleReader.sc.nextLine();
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
        String id= IdGenerator.createBookId();
        Books newBook = new Books(id, title, author, year );
        Library.addBook(newBook);
        System.out.println("Book registered succesfully");
    }

    public int getYear() {
        return year;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public boolean isItsAvailable() {
        return itsAvailable;
    }

    public void setItsAvailable(boolean itsAvailable) {
        this.itsAvailable = itsAvailable;
    }

}
