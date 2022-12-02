import java.math.BigInteger;

/**
 * Program to help with Problem 8.4 part 3.
 * @author Zeke Krug
 * @author Conner Hettinger
 */
public class Problem_85 {
    public static void main(String[] args){
        computePublicKeys();
    }

    public static void computePublicKeys(){
        BigInteger p = new BigInteger("467");
        BigInteger alpha = new BigInteger("2");
        BigInteger a = new BigInteger("400");
        BigInteger b = new BigInteger("134");

        BigInteger A = alpha.modPow(a, p);
        BigInteger B = alpha.modPow(b, p);
        BigInteger Ba = B.modPow(a, p);
        BigInteger Ab = A.modPow(b, p);
        System.out.println("The public keys are: " + A + " and " + B);
        System.out.println("The common key is: ");
        System.out.println("B^400 mod 467 = " + Ba);
        System.out.println("A^134 mod 467 = " + Ab);
    }

}


