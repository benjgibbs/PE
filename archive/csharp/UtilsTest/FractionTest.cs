using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Utils;

namespace UtilsTest
{
    [TestClass]
    public class FractionTest
    {
        [TestMethod]
        public void TestEquals()
        {
            Assert.AreEqual(new Fraction(50, 100), new Fraction(1, 2));
            Assert.AreEqual(new Fraction(100, 100), new Fraction(1));
        }

        [TestMethod]
        public void TestDigitCount()
        {
            Fraction f = new Fraction(17,1713);
            Assert.AreEqual(2U, f.NumeratorDigits());
            Assert.AreEqual(4U, f.DenominatorDigits());
        }
    }
}
