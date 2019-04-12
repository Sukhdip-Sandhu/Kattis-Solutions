import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VerifyQueen {
    public static void main(String[] args) throws FileNotFoundException {

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine());

        for (int i = 0; i < N; i++) {
            String[] l = in.nextLine().split(" ");
            hashMap.put(Integer.parseInt(l[0]),Integer.parseInt(l[1]));
        }

        if (evaluate(hashMap,N))
            System.out.println("CORRECT");
        else
            System.out.println("INCORRECT");
    }

    private static boolean evaluate(HashMap<Integer, Integer> hashMap, int N) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < hashMap.size(); i++) {
            if (!hashMap.containsKey(i) || !hashMap.containsValue(i)){
                return false;
            }
        }

        for (int i = 0; i < hashMap.size(); i++)
            hashSet.add(i+hashMap.get(i));

        if (hashSet.size() != N)
            return false;

        hashSet.clear();

        for (int i = 0; i < hashMap.size(); i++)
            hashSet.add(i-hashMap.get(i));

        return hashSet.size() == N;
    }
	
}
