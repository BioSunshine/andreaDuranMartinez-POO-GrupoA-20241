public class Showlists {

    public static void menuLists(){
        boolean band =true;
        do{
            System.out.println("\t\t>>>Welcome to database<<<\n What do you want to check?\n 1)See registered Users\n" +
                    " 2)See users that have rented a least a Book \n 3)See All the Books\n 4)See Books available\n 5)See rented books\n" +
                    " 0) Return");
            int option = ConsoleReader.sc.nextInt();
            switch (option){
                case 1-> {//See Users
                    int ID = 0;
                    for (Users user : Library.getUserlist()){ //tipoobjeto loquesea: lista
                        System.out.println("| ID: "+ (ID+1)+" | code: "+user.getId()+" | Name: "+user.getName()+" | Lastname: "+user.getLastname()+" | Age: "+user.getAge());
                        ID++;
                    }
                }
                case 2 -> {//see users have rented books. Preguntar si también es una lista de comprados, no solo rentado
                    int ID =0;
                    for (Users user : Library.getUserlist()){
                        if(user.isHasRentedBook()==true){
                        System.out.println("|ID: "+(ID+1)+" | code: "+user.getId()+" | Name: "+user.getName()+" | Lastname: "+user.getLastname()+ " | Age: "+user.getAge());
                        }
                    ID++;
                    }
                }
                case 3 -> {//All the books
                    int ID=0;
                    for(Books book : Library.getBooklist()){
                        System.out.println(" | ID: "+(ID+1)+" | code: "+book.getId()+" | Title: "+book.getTitle()+" | Author: "+book.getAuthor()+" | Publication year: "+book.getYear());
                        ID++;
                    }
                }
                case 4 ->{//Libros disponibles
                    int ID=0;
                    for(Books availables : Library.getBooklist()){
                        if (availables.isItsAvailable()==true){
                            System.out.println("|ID: "+ (ID+1)+"code: "+availables.getId()+" | Title: "+availables.getTitle()+" | Author: "+availables.getAuthor()+" | Publication year: "+availables.getYear());
                        }
                        ID++;
                    }
                }
                case 5 ->{ //libros rentados
                    int ID=0;
                    for(Books rentedBooks : Library.getBooklist()){
                        if (rentedBooks.isItsAvailable()==false){
                            System.out.println("|ID: "+(ID+1)+"code: "+rentedBooks.getId()+" | Title: "+rentedBooks.getTitle()+"| Author: "+rentedBooks.getAuthor()+" | Publication year: "+rentedBooks.getYear());
                        }
                        ID++;
                    }
                }
                case 0->{
                band=false;
                }
                default -> {
                    System.out.println("Not a valid input...");
                }
            }

        }while (band==true);
    }
}
