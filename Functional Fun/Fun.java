import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Fun {

    public static void main(String[] args) throws FileNotFoundException {
        
		Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            HashMap<String, Integer> domainMap = new HashMap<>();
            HashMap<String, Integer> codomainMap = new HashMap<>();

            String[] domain = in.nextLine().split(" ");
            String[] codomain = in.nextLine().split(" ");

            for (int i = 0; i < domain.length - 1; i++)
                domainMap.put(domain[i + 1], i);

            for (int i = 0; i < codomain.length - 1; i++)
                codomainMap.put(codomain[i + 1], i);

            int[] domainArray = new int[domain.length-1];
            int[] codomainArray = new int[codomain.length-1];

            int n = Integer.parseInt(in.nextLine());

            while (n != 0) {
                String[] line = in.nextLine().split(" ");
                domainArray[domainMap.get(line[0])]++;
                codomainArray[codomainMap.get(line[2])]++;
                n--;
            }
            Analyze(domainArray, codomainArray);
        }
    }

    private static void Analyze(int[] domainArray, int[] codomainArray) {
        boolean isNotAFunction = false;
        boolean isSurjective = false;
        boolean isInjective = false;

        isNotAFunction = Test_If_Not_Function(domainArray);
        isSurjective = Test_If_Surjective(codomainArray);
        isInjective = Test_If_Injective(codomainArray);

        if (isNotAFunction){print_not_a_function();return;}
        if (isSurjective && isInjective){print_bijective();return;}
        if (isInjective &! isSurjective){print_injective();return;}
        if (isSurjective){print_surjective();return;}

        print_neither();

    }

    private static boolean Test_If_Injective(int[] codomainArray) {
        for (int i : codomainArray) if (i > 1) return false;
        return true;
    }

    private static boolean Test_If_Surjective(int[] codomainArray) {
        for (int i : codomainArray) if (i == 0) return false;
        return true;
    }

    private static boolean Test_If_Not_Function(int[] domainArray) {
        for (int i:domainArray) if (i > 1) return true;
        return false;
    }


    public static void print_bijective(){System.out.println("bijective");}
    public static void print_surjective(){System.out.println("surjective");}
    public static void print_injective(){System.out.println("injective");}
    public static void print_not_a_function(){System.out.println("not a function");}
    public static void print_neither(){System.out.println("neither injective nor surjective");}

}

