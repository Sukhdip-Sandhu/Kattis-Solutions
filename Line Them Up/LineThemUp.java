import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LineThemUp {

    public static void main(String[] args) throws FileNotFoundException {

        int Increasing = 0;
        int Decreasing = 0;

        Scanner in = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        int numOfPpl = Integer.parseInt(in.nextLine());

        while (in.hasNext()) {
            names.add(in.nextLine());
        }

        for (int i = 0; i < numOfPpl-1; i++) {
            if (names.get(i).compareTo(names.get(i+1)) > 0){
                Decreasing++;
            }else if(names.get(i).compareTo(names.get(i+1)) < 0){
                Increasing++;
            }
        }

        if (Increasing!=0 && Decreasing==0){
            System.out.print("INCREASING");
        }else if (Increasing==0 && Decreasing!=0){
            System.out.print("DECREASING");
        }else{
            System.out.print("NEITHER");
        }
    }
}
