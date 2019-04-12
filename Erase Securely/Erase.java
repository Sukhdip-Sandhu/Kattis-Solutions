import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Erase {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine());

        String[] a = in.nextLine().split("");
        String[] b = in.nextLine().split("");

        boolean changed = true;
        if (N%2==0){
            changed = false;
        }

        if (changed) {
            for (int i = 0; i < a.length; i++) {
                if (a[i].equals(b[i])){
                    System.out.println("Deletion failed");
                    return;
                }
            }
        }

        if (!changed) {
            for (int i = 0; i < a.length; i++) {
                if (!(a[i].equals(b[i]))){
                    System.out.println("Deletion failed");
                    return;
                }
            }
        }

        System.out.println("Deletion succeeded");
    }
}
