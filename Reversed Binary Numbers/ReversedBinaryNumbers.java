import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReversedBinaryNumbers {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int original = Integer.parseInt(in.nextLine());
        in.close();

        String binaryString = Integer.toBinaryString(original);

        for (int i = 0; i < binaryString.length(); i++) {
            stringBuilder.append(binaryString.charAt(i));
        }

        StringBuilder aa = stringBuilder.reverse();
        System.out.print(Integer.parseInt(aa.toString(),2));

    }
}
