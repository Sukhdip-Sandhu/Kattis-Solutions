import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NoDuplicates {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        String[] words = in.nextLine().split(" ");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String word : words) {

            if (arrayList.contains(word)){
                System.out.print("no");
                return;
            }else {
                arrayList.add(word);
            }

        }
        System.out.print("yes");
    }

}
