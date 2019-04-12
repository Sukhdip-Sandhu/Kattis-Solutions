import java.util.Scanner;

public class Kitten {
    public static void main(String[] args) {
        int[] array = new int[101];
        Scanner in = new Scanner(System.in);

        int beg = in.nextInt();
        in.nextLine();

        while (in.hasNext()){
            String line = in.nextLine();

            if (line.equals("-1")){ in.close(); break; }

            String[] split = line.split(" ");

            for (int i = 1; i < split.length; i++){
                array[Integer.parseInt(split[i])] = Integer.parseInt(split[0]);
            }
        }

        int a = beg;
        System.out.print(a);
        while (a!=0) {
            a = array[beg];
            if (a == 0) {
                System.out.println();
                break;
            }
            System.out.print(" " + a);
            beg = a;
        }
    }
}
