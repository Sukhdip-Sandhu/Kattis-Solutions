import java.util.Scanner;

public class ColdputerScience {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        System.out.print(in.nextLine().split("-").length-1);
    }
}
