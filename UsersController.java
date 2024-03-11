public class UsersController {

    public static void createUser(){
        System.out.println("Introduce the name: ");
        String name = ConsoleReader.sc.nextLine();
        System.out.println("Introduce the lastname: ");
        String lastname= ConsoleReader.sc.nextLine();

        //tiene que haber validación
        if(name.isEmpty()&&lastname.isEmpty()){
            System.out.println("Input invalid...");

        }
        else {
            System.out.println("Introduce the age");
            int age = ConsoleReader.sc.nextInt();
            if (age < 6){
                System.out.println("Not possible to register with that age ");
                return;
            }
            long id = IdGenerator.createId();
            Users newUser = new Users(id, name,lastname,age);
            Library.addUser(newUser);
        }
    }
}
