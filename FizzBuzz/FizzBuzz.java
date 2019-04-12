import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        int X = in.nextInt(); // FIZZ
        int Y = in.nextInt(); // BUZZ
        int N = in.nextInt(); // FIZZBUZZ

        int[] ints = new int[N];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i+1;
        }

        for (int i:ints) {
            if (i%X==0 && i%Y==0) {
                System.out.println("FizzBuzz");
            }else if (i%X==0 && i%Y!=0){
                System.out.println("Fizz");
            }else if (i%X!=0 && i%Y==0){
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }
    }
}

