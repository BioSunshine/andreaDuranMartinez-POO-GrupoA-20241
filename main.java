public class main {
    public static void main(String[] args) {
        Person person1 = new Person("Paola", "Cobian", 26, true);
        Person person2 = new Person("David", "Servin", 28, false);
        Person person3 = new Person("Atziri", "Mancilla", 27, true);
        Person person4 = new Person("Alejandro", "Diaz", 20, false);
        System.out.println(person1.getPersonInfo());
        System.out.println(person2.getPersonInfo());
        System.out.println(person3.getPersonInfo());
        System.out.println(person4.getPersonInfo());
        System.out.println();


        Book book = new Book();

        //crea 3 más, modifica y muestra
        Book book2 = new Book ();
        Book book3 = new Book ();
        Book book4 = new Book ();
        book2.title = "Momo";
        book2.author = "Michael Ende";
        book2.publicationYear= 1972;
        book3.title = "El amante japonés";
        book3.author = "Isabel Allende";
        book3.publicationYear = 2015;
        book4.title = "El gen egoísta";
        book4.author= "Richard Dawkins";
        book4.publicationYear = 1976;
        System.out.println( book.getBookInfo());
        System.out.println( book2.getBookInfo());
        System.out.println(book3.getBookInfo());
        System.out.println(book4.getBookInfo());
        System.out.println("");

        Rectangle rectangle1 = new Rectangle(1,3.1, 4.6, "verde");
        rectangle1.showResults();
        Rectangle rectangle2 = new Rectangle(2, 14.2, 4.5, "azul");
        rectangle2.showResults();
        Rectangle rectangle3 = new Rectangle(3, 5.6, 3.8, "rojo");
        rectangle3.showResults();
        Rectangle rectangle4 = new Rectangle(4, 1.4, 20.1, "amarillo");
        rectangle4.showResults();
        System.out.println(rectangle1.getRectangleInfo());
        System.out.println(rectangle2.getRectangleInfo());
        System.out.println(rectangle3.getRectangleInfo());
        System.out.println(rectangle4.getRectangleInfo());
    }
}
