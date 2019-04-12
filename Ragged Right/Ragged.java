import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ragged {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (in.hasNext()){
            String l = in.nextLine();
            arrayList.add(l.length());
        }

        int largest = Collections.max(arrayList);
        arrayList.remove(arrayList.size()-1);
        evaluate(arrayList, largest);

    }

    private static void evaluate(ArrayList<Integer> arrayList, int largest) {
        arrayList.sort(null);

        int sum = 0;
        for (int x : arrayList) {
            sum += (largest-x) * (largest-x);
        }

        System.out.println(sum);
    }
}
