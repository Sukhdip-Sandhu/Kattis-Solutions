import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class CompoundWords {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        TreeSet<String> treeSet1 = new TreeSet<>();
        TreeSet<String> treeSet2 = new TreeSet<>();

        while (in.hasNext()){
            String[] line = in.nextLine().split(" ");
            for (String l : line) {
                treeSet1.add(l);
            }
        }

        Object[] array = treeSet1.toArray();

        for (int i = 0; i < treeSet1.size(); i++) {
            for (int j = 0; j < treeSet1.size() ; j++) {
                if (i!=j){
                    String one = (String) array[i];
                    String two = (String) array[j];
                    treeSet2.add(one+two);
                }
            }
        }

        for (String s : treeSet2) {
            System.out.println(s);
        }
    }
}

