import java.util.Random;

public class IdGenerator {
    public static long createId(){

        long idNumber = 25;

        Random ran = new Random();
        for (int i =0; i<3; i++){
            long idNumber2 = ran.nextLong(10);
            idNumber+=idNumber2;
        }
        return idNumber;
    }
    public static long createBookId(){
        long idNumber = 1;

        Random ran = new Random();
        for (int i =0; i<3; i++){
            long idNumber2 = ran.nextLong(10);
            idNumber+=idNumber2;
        }
        return idNumber;
    }
}

