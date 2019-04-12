import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UnBearAbleZoo {



    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        int testCase = 1;
        while (in.hasNext()) {


            TreeSet<String> animals = new TreeSet<>();
            TreeMap<String, Integer> treeMap = new TreeMap<>();
            int n = Integer.parseInt(in.nextLine());

            if (n==0){
                return;
            }

            for (int i = 0; i < n; i++) {
                String[] line = in.nextLine().toLowerCase().split(" ");
                String animalName = line[line.length - 1];
                if (animals.contains(animalName)) {
                    int val = treeMap.get(animalName);
                    treeMap.put(animalName, (val + 1));
                } else {
                    animals.add(animalName);
                    treeMap.put(animalName, 1);
                }
            }
            System.out.println("List " + testCase + ":");
            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                System.out.println(entry.getKey() + " | " + entry.getValue());
            }
            testCase++;
        }

    }
}
