using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Numerics;

namespace Utils
{
    public class Fraction
    {
        private BigInteger n, d;

        public Fraction(BigInteger n)
            : this(n, 1)
        {
        }

        public Fraction(BigInteger n, BigInteger d)
        {
            BigInteger gcd = GCD(BigInteger.Min(n, d), BigInteger.Max(n, d));
            this.n = n / gcd;
            this.d = d / gcd;
        }

        public Fraction(BigInteger n, Fraction d)
            : this(n * d.d, d.n)
        {
        }

        static BigInteger GCD(BigInteger x, BigInteger y)
        {
            BigInteger Remainder;
            while (y != 0)
            {
                Remainder = x % y;
                x = y;
                y = Remainder;
            }
            return x;
        }

        public uint NumeratorDigits()
        {
            return CountDigits(n);
        }

        private uint CountDigits(BigInteger n)
        {
            uint count = 0;
            while (n > 0)
            {
                count += 1;
                n = n / 10;
            }
            return count;
        }

        public uint DenominatorDigits()
        {
            return CountDigits(d);
        }

        public static Fraction operator +(Fraction lhs, Fraction rhs)
        {
            return new Fraction(lhs.n * rhs.d + rhs.n * lhs.d, rhs.d * lhs.d);
        }

        public override string ToString()
        {
            return String.Format("{0}/{1}", n, d);
        }

        public static bool operator ==(Fraction lhs, Fraction rhs)
        {
            if ((object)lhs == null) return (object)rhs == null;
            if ((object)rhs == null) return false;
            return lhs.n == rhs.n && lhs.d == rhs.d;
        }

        public static bool operator !=(Fraction lhs, Fraction rhs)
        {
            return !(rhs == lhs);
        }

        public override int GetHashCode()
        {
            return ((int)d << 8) + (int)n;
        }

        public override bool Equals(object obj)
        {
            Fraction rhs = obj as Fraction;
            if (rhs == null)
                return false;
            return this == rhs;
        }
    }

}
