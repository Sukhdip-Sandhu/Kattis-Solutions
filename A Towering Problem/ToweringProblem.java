import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ToweringProblem {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        int[] boxs = new int[6];
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            boxs[i] = in.nextInt();
        }

        int t1 = in.nextInt();
        int t2 = in.nextInt();

        Arrays.sort(boxs);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {

                    if (i != j || i != k){
                        if ((boxs[i]+boxs[j]+boxs[k]) == t1){

                            for (int l = 0; l < 6; l++) {
                                if (l!=i){
                                    if (l!=j){
                                        if (l!=k){
                                            nums.add(l);
                                        }
                                    }
                                }
                            }

                            if ((boxs[nums.get(0)]+boxs[nums.get(1)]+boxs[nums.get(2)]) == t2){



                                TreeSet<Integer> treeSet1 = new TreeSet<>(Collections.reverseOrder());
                                TreeSet<Integer> treeSet2 = new TreeSet<>(Collections.reverseOrder());

                                treeSet1.add(boxs[i]);
                                treeSet1.add(boxs[j]);
                                treeSet1.add(boxs[k]);
                                treeSet2.add(boxs[nums.get(0)]);
                                treeSet2.add(boxs[nums.get(1)]);
                                treeSet2.add(boxs[nums.get(2)]);
                                System.out.print(treeSet1.pollFirst() + " ");
                                System.out.print(treeSet1.pollFirst() + " ");
                                System.out.print(treeSet1.pollFirst() + " ");
                                System.out.print(treeSet2.pollFirst() + " ");
                                System.out.print(treeSet2.pollFirst() + " ");
                                System.out.print(treeSet2.pollFirst());

                                return;
                            }else{
                                nums.clear();
                            }
                        }
                    }
                }
            }
        }
    }
}

