public class Book {
    java.lang.String title = "Ensayo sobre la cegera";
    java.lang.String author = "Jose Saramago";
    int publicationYear = 1995;
    public void showInfo (){
        System.out.println(" ");
        System.out.println("title: "+title+"\n"+" author: "+author+"\n"+" publicationYear: "+publicationYear);
        System.out.println(" ");
    }
    String getBookInfo () {
        return String.format(
                "title: %s, author: %s, publicationYear: %d",
                title, author, publicationYear);
    }
}
