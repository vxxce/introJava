public class Fraction {
    private int n;
    private int d;

    Fraction(int n, int d) throws Exception {
        if (d == 0) throw new Exception("Invalid Fraction (denominator cannot be 0).");

        // Normalize Fractions so numerator exclusively responsible for sign (e.g. 2/-3 => -3/2,
        // -4/-2 => 4/2)
        this.n = (n * d >= 0) ? Math.abs(n) : 0 - Math.abs(n);
        this.d = Math.abs(d);
    }

    // Default to 1/1 when no arguments provided
    Fraction() {
        this.n = this.d = 1;
    }

    @Override
    public String toString() {
        return String.valueOf(n) + "/" + String.valueOf(d);
    }

    public Double getDecimal() {
        return n / (double) d;
    }

    public void reduce() {
        int n1, n2, gcd;

        // Ignore sign temporarily.
        n1 = Math.abs(n);
        n2 = (n1 == 0) ? 0 : d;
        gcd = 1;

        // Get greatest common denominator. GCD of 2 positive #s always same as the GCD of
        // (larger # - smaller #) and smaller #.
        while (n1 != n2 && n1 != 0) {
            if (n1 > n2) n1 -= n2;
            else n2 -= n1;
            gcd = n1; // GCD found when n1 and n2 equal.
        }

        // Reduce, and recover sign
        n /= gcd;
        d /= gcd;
    }

    public String toMixed() throws Exception {
        Fraction fMod;
        int quotient, remainder;

        if (n == d) return "1";
        if (n == -d) return "-1";
        if (n == 0) return "0";

        quotient = n / d;
        remainder = Math.abs(n % d);

        // Make new Fraction with remainder and reduce.
        fMod = new Fraction(remainder, d);
        fMod.reduce();

        // Show quotient if non-zero or if quotient and remainder both 0. Otherwise show whichever
        // is non-zero.
        if (quotient == 0 ^ remainder == 0) {
            if (quotient == 0) return fMod.toString();
            if (remainder == 0) return String.valueOf(quotient);
        }
        return String.valueOf(quotient) + " " + fMod.toString();
    }
}