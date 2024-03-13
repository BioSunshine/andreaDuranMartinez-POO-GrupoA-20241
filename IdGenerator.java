import java.util.Random;

public class IdGenerator {
    public static String createId(){

        String idNumber = "24";

        Random ran = new Random();
        for (int i =0; i<3; i++){
            int idNumber2 = ran.nextInt(10);
            idNumber+=idNumber2;
        }
        return idNumber;
    }
    public static String createBookId(){
        String idNumber = "12";
        int Booknumber;
        Random ran = new Random();
        for (int i =0; i<3; i++){
             Booknumber = ran.nextInt(10);
             idNumber+=Booknumber;
        }
        return idNumber;
    }
}

