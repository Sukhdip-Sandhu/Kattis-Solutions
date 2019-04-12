import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class EightQueens {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int row = 0;

        while (in.hasNext()) {
            String s[] = in.nextLine().split("");
            for (int col = 0; col < s.length; col++) {
                if (s[col].equals("*")){
                    hashMap.put(row,col);
                    row++;
                    break;
                }
            }
        }

        //boolean valid = evaluate(hashMap);

        if (evaluate(hashMap))
            System.out.println("valid");
        else
            System.out.println("invalid");
    }

    private static boolean evaluate(HashMap<Integer, Integer> hashMap) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < hashMap.size(); i++) {
           if (!hashMap.containsKey(i) || !hashMap.containsValue(i)){
               return false;
           }
        }

        for (int i = 0; i < hashMap.size(); i++)
            hashSet.add(i+hashMap.get(i));

        if (hashSet.size() != 8)
            return false;

        hashSet.clear();

        for (int i = 0; i < hashMap.size(); i++)
            hashSet.add(i-hashMap.get(i));

        return hashSet.size() == 8;
    }
}
