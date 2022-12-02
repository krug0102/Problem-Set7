import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Program to help with Problem 8.4 part 3.
 * @author Zeke Krug
 * @author Conner Hettinger
 */
public class Problem_84 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 4969; i++) {
            if(testGenerator(new BigInteger(String.valueOf(i)))){
                System.out.println(i + " is a generator.");
                count++;
            }
        }
        System.out.println("There are " + count + "generators.");
    }

    /*
    If true, a is a generator.
     */
    public static boolean testGenerator(BigInteger a){
        ArrayList<BigInteger> row = new ArrayList<>();
        for (int i = 1; i < 4969; i++) {
                row.add(a.modPow(new BigInteger(String.valueOf(i)), new BigInteger("4969")));
        }
        return row.stream().map(BigInteger::intValue).distinct().count() == row.size(); // this line was adapted from a stack overflow post.

    }
}