import java.math.BigInteger;

public class Problem_814 {

    public static void main(String[] args) {
        BigInteger p = new BigInteger("31");
        BigInteger alpha = new BigInteger("3");
        BigInteger Ke = new BigInteger("6");
        BigInteger exp = null;
        for(int i = 2; i < 29; i++) {
            BigInteger res = alpha.modPow(new BigInteger(String.valueOf(i)), p);
            if(Ke.equals(res)){
                exp = new BigInteger(String.valueOf(i));
            }
        }

        BigInteger beta = new BigInteger("18");
        System.out.println("i is: " + exp);
        BigInteger Km = beta.modPow(exp, p);
        System.out.println("Km is: " + Km);

        BigInteger y = new BigInteger("25");
        BigInteger KmInverse = Km.modInverse(p);
        System.out.println("Km Inverse is: " + KmInverse);
        BigInteger prod = y.multiply(KmInverse);
        BigInteger x = prod.mod(p);

        System.out.println("The second plaintext is: " +  x);
    }
}
