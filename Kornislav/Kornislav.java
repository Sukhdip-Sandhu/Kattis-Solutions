import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Kornislav {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        int[] array = new int[4];

        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(A);
        arrayList.add(B);
        arrayList.add(C);
        arrayList.add(D);

        arrayList.sort(null);
        int dist = arrayList.get(0) * arrayList.get(2);
        System.out.println(dist);

    }
}
