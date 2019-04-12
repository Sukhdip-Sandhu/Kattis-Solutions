import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bishops {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new File(args[0]));

        while (in.hasNext()){
            int n = in.nextInt();

            if (n==1){
                System.out.println("1");
            }else{
                System.out.println((2*n)-2);
            }
        }
    }
}