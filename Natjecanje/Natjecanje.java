import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Natjecanje {

    public static boolean[][] twoDArray;
    public static int ARRAYSIZE;
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int S = in.nextInt();
        int R = in.nextInt();

        twoDArray = new boolean[N][2];
        ARRAYSIZE = N;

        for (int i = 0; i < S; i++) {
            int damaged = in.nextInt();
            twoDArray[damaged-1][0] = true;
        }

        for (int i = 0; i < R; i++) {
            int damaged = in.nextInt();
            twoDArray[damaged-1][1] = true;
        }

        evaluate();

    }

    private static void evaluate() {
        int counter = 0;
        for (int i = 0; i < twoDArray.length; i++) {
            if (twoDArray[i][0]){
                if (!ableToGetReserve(i)){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    private static boolean ableToGetReserve(int i) {
        try {
            if (twoDArray[i][1]) {
                twoDArray[i][1] = false;
                return true;
            }
        }catch (Exception ignored){}

        try {
        if ((i - 1) >= 0) {
            if (twoDArray[i - 1][1]) {
                twoDArray[i - 1][1] = false;
                return true;
            }
        }
        }catch (Exception ignored){}

        try {
        if ((i+1)<= ARRAYSIZE){
            if (twoDArray[i + 1][1]) {
                twoDArray[i + 1][1] = false;
                return true;
            }
        }
        }catch (Exception ignored){}

        return false;
    }

}
