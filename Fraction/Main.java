public class Main {

    public static void main(String[] args) {
        Fraction f;

        f = new Fraction(4,10);

        System.out.println(f.getDecimal());
        System.out.println(f.toString());
        f.reduce();
        System.out.println(f.toMixed());

    }
}
