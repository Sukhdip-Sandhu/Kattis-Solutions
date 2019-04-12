import java.util.Scanner;
import java.math.BigInteger;

public class TreeInsert {

    public static void postOrderRecursiveAnalysis(BinarySearchTree.Node root) {
        if (root != null) {
            postOrderRecursiveAnalysis(root.left);
            postOrderRecursiveAnalysis(root.right);

            if (root.left==null && root.right==null)
            {
                root.interL = new BigInteger("1");
                root.numC = new BigInteger("1");
            }
            else if (root.left!=null && root.right!=null)
            {
                root.numC = root.left.numC.add(root.right.numC).add(BigInteger.valueOf(1));
                root.interL = root.left.interL.multiply(root.right.interL).multiply(interleavingBIGINT(root.left.numC,root.right.numC));
            }
            else
            {
                if (root.left==null){
                    root.numC = new BigInteger("1").add(root.right.numC);
                    root.interL = root.right.interL;
                }else {
                    root.numC = new BigInteger("1").add(root.left.numC);
                    root.interL = root.left.interL;
                }
            }
        }
    }

    public static BigInteger factorialBIGINT(BigInteger n){
        if (n == BigInteger.ONE || n == BigInteger.ZERO){
            return BigInteger.ONE;
        }
        return n.multiply(factorialBIGINT(n.subtract(BigInteger.ONE)));
    }

    public static BigInteger interleavingBIGINT(BigInteger l, BigInteger r){
        return factorialBIGINT(l.add(r)).divide((factorialBIGINT(l).multiply(factorialBIGINT(r))));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            BinarySearchTree tree = new BinarySearchTree();

            int n = Integer.parseInt(in.nextLine());
            if (n==0){return;}

            String[] nodes = in.nextLine().split(" ");

            for (String s:nodes) {
                tree.insert(Integer.parseInt(s));
            }

            postOrderRecursiveAnalysis(tree.root);
            System.out.println(tree.root.interL);

        }
    }

}
