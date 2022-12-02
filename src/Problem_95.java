import java.math.BigInteger;

public class Problem_95 {
    public static void main(String[] args) {

        // Tests to make sure add and double work.
        System.out.println("Tests to make sure add and double work.\n");
        Point a = new Point(2, 7);
        a.add(new Point(5, 2), 17);

        Point b = new Point(3, 6);
        b.dubble(2, 17);

        System.out.println("Computing all points on E over Z7:\n");
        Point generator = new Point(2, 4);
        System.out.println(generator);

        generator.computePoints(3, 7);

        System.out.println("Computing all points with alpha = (0, 3):\n");
        Point generator2 = new Point(0, 3);
        System.out.println(generator2);

        generator2.computePoints(3, 7);

        System.out.println("DHKE based on elliptic curves");
        System.out.println("Compute aB = 6 * (5, 9) = 2 * (2B + B)\n");
        Point B = new Point(5, 9);
        Point twoB = B.dubble(1, 11);
        Point twoBplusB = twoB.add(B, 11);
        Point result = twoBplusB.dubble(1, 11);
        System.out.println("aB = " + result);
        System.out.println("The shared key is: " + result.x);

    }

    public static class Point{
        BigInteger x;
        BigInteger y;

         Point(int x, int y) {
            this.x = new BigInteger(String.valueOf(x));
            this.y = new BigInteger(String.valueOf(y));
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }

        /**
         *
         * @param point
         * @param p
         */
        public Point add(Point point, int p){
            BigInteger bigP = new BigInteger(String.valueOf(p));
            BigInteger s = (point.y.subtract(this.y)).multiply((point.x.subtract(this.x)).modInverse(bigP)).mod(bigP);
            BigInteger x3 = (s.pow(2).subtract(this.x).subtract(point.x)).mod(bigP);
            BigInteger y3 = s.multiply(this.x.subtract(x3)).subtract(this.y).mod(bigP);
            Point result = new Point(x3.intValue(), y3.intValue());
            System.out.println(this.toString() + " + " + point.toString() + " = " + result.toString());
            return result;
        }

        public Point dubble(int a, int p){
            BigInteger bigA = new BigInteger(String.valueOf(a));
            BigInteger bigP = new BigInteger(String.valueOf(p));
            BigInteger three = new BigInteger("3");
            BigInteger two = new BigInteger("2");
            BigInteger num = (three.multiply(this.x.pow(2)).add(bigA));
            BigInteger denom = two.multiply(this.y).modInverse(bigP);
            BigInteger s = num.multiply(denom).mod(bigP);
            BigInteger xpinata = s.multiply(s).subtract(two.multiply(this.x)).mod(bigP);
            BigInteger ypinata = (s.multiply(this.x.subtract(xpinata)).subtract(this.y)).mod(bigP);
            Point result = new Point(xpinata.intValue(), ypinata.intValue());
            System.out.println("2 * " + this.toString() + " = " + result.toString());
            return result;
        }

        public void computePoints(int a, int p){
            Point g2 = this.dubble(a, p);

            Point curr = g2.add(this,p);

            while(true) {
                if (curr.x.equals(this.x)) {
                    break;
                }
                curr = curr.add(this, p);
            }
        }


    }

}
