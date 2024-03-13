import java.util.Random;

public class IdGenerator {
    public static String createId(){

        StringBuilder idNumber = new StringBuilder("24");

        Random ran = new Random();
        for (int i =0; i<3; i++){
            int idNumber2 = ran.nextInt(10);
            idNumber.append(idNumber2);
        }
        return idNumber.toString();
    }
    public static String createBookId(){
        StringBuilder idNumber = new StringBuilder("12");
        int Booknumber;
        Random ran = new Random();
        for (int i =0; i<3; i++){
             Booknumber = ran.nextInt(10);
             idNumber.append(Booknumber);
        }
        return idNumber.toString();
    }
}

