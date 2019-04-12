import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Different {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);


        while (in.hasNext()) {
            long a = in.nextLong();
            long b = in.nextLong();
            System.out.println(Math.abs(b-a));
        }
    }
}
