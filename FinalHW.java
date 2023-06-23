/**
 * @author Umut ALTUN
 * @since 23.06.2023
 */
public class FinalHW {
    public static void main(String[] args) {

        System.out.println("V0 => " + potentialOfRod(1, Math.pow(10,-9), 1));
        System.out.println("V1 => " +  potOfPointCharges(1,Math.pow(10,-9),1,1));
        System.out.println("V2 => " +  potOfPointCharges(1,Math.pow(10,-9),1,2));
        System.out.println("V4 => " +  potOfPointCharges(1,Math.pow(10,-9),1,4));
        System.out.println("V6 => " +  potOfPointCharges(1,Math.pow(10,-9),1,6));
        System.out.println("V8 => " +  potOfPointCharges(1,Math.pow(10,-9),1,8));
        System.out.println("VN => " +  potOfPointCharges(1,Math.pow(10,-9),1,999999999));

    }
    static final double K = 8.98 * Math.pow(10,9);
    public static double potentialOfRod(double x, double q, double L){
        double firstSection = (K * q) / (2.0 * L);
        double sqrt = Math.sqrt(L * L + x * x);
        return firstSection * Math.log((sqrt + L) / (sqrt - L)) / Math.log(Math.E);
    }

    public static double potOfPointCharges(double x, double q, double L, int pieces){
        double baseCase = 0;
        /*In this section, if an odd number is entered, a part of the divided q value
        for the divisor is placed in the center and the calculation continues as normal
        since the remaining number of parts will be even.
         */
        if(pieces % 2 == 1){
            baseCase = (K * q) / x / pieces;
            q = q - (q / pieces);
            pieces--;
        }
        if (pieces == 0)
            return baseCase;
        double firstSection = (2.0 * K * q) / pieces;
        double a = Math.abs(L / (pieces - 1));//This line shows how the L value should be initialized.
        double totalPotential = 0;
        while(a <= L){
            totalPotential += firstSection / (Math.sqrt(x*x + a*a));
            a += 2 * Math.abs(L / (pieces - 1));
        }
        return totalPotential + baseCase;
    }
}

