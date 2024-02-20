//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Paola", "Cobian", 26, true);
        Person person2 = new Person("David", "Servin", 28, false);
        Person person3 = new Person("Atziri", "Mancilla", 27, true);
        Person person4 = new Person("Alejandro", "Diaz", 20, false);

        person1.showFeatures();
        person2.showFeatures();
        person3.showFeatures();
        person4.showFeatures();
        Book book = new Book();
        book.showInfo();
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
        book2.showInfo();
        book3.showInfo();
        book4.showInfo();
        Rectangle rectangle1 = new Rectangle(1,3, 4, "verde");
        rectangle1.showResults();
        Rectangle rectangle2 = new Rectangle(2, 3.1, 4.5, "azul");
        rectangle2.showResults();
        Rectangle rectangle3 = new Rectangle(3, 5.1, 3.4, "rojo");
        rectangle3.showResults();
        Rectangle rectangle4 = new Rectangle(4, 1.1, 20, "amarillo");
        rectangle4.showResults();        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}