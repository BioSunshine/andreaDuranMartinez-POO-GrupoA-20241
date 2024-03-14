public class Book {
    private String  id;
    private String title;
    private String author;
    private int year;
    private boolean itsAvailable = true;

    public Book(String id, String title, String author, int year, boolean itsAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.itsAvailable = itsAvailable;
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
