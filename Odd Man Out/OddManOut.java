import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OddManOut {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        int testCases = Integer.parseInt(in.nextLine());
        int i = 1;
        while (testCases > 0){
            ArrayList<String> couples = new ArrayList<>();
            int numOfGuests = Integer.parseInt(in.nextLine());
            String guests = in.nextLine();
            String[] guestsSplit = guests.split(" ");
            for (String c : guestsSplit) {

                if (couples.contains(c)){
                    couples.remove(c);
                }else {
                    couples.add(c);
                }
            }
            System.out.println("Case #" + i + ":  " + couples.get(0));
            i++;
            testCases--;
        }
    }
}

