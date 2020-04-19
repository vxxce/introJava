public class Fraction {
    private int numerator;
    private int denominator;

    Fraction()
    {
        this.numerator = 1;
        this.denominator = 1;
    }

    Fraction(int n, int d)
    {
        this.numerator = n;
        this.denominator = d;
    }

    public String toString()
    {
        return String.valueOf(numerator) + "/" +String.valueOf(denominator);
    }

    public Double getDecimal()
    {
        return this.numerator / (double) this.denominator;
    }

    public void reduce()
    {
        int larger;
        int smaller;
        if (this.numerator >= this.denominator)
        {
            larger = this.numerator;
            smaller = this.denominator;
        }
        else
        {
            larger = this.denominator;
            smaller = this.numerator;
        }
     }

    public String toMixed()
    {
        // '35/10' => '3 1/2'
        return "to mixed";
    }
}
