public class Person {
    String name;
    String lastname;
    int age;
    boolean isFemale;
    public Person(java.lang.String name, java.lang.String lastname, int age, boolean isFemale) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.isFemale = isFemale;
    }

    public void showFeatures(){
        System.out.println("Hola, soy "+name+" "+lastname+" y tengo "+age+" años ");
        if(isFemale==true){
            System.out.print(" y soy una chica linda");
        }
        else {System.out.print(" y soy un chico");
        }
        System.out.println("");
        System.out.println("");
    }
    //otra forma
    String getPersonInfo (){
        /*
        %s - String
        %d - int
        %b - boolean
        */
        return String.format(
                "Name: %s  lastname: %s Age: %d Is female? %b",
                name, lastname, age, isFemale);
    }
}
