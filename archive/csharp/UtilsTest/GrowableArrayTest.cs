using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Utils;

namespace UtilsTest
{
    [TestClass]
    public class GrowableArrayTest
    {
        [TestMethod]
        public void TestArrayAccess()
        {
            int sz = 100;
            GrowableArray<int> ga = new GrowableArray<int>(sz);
            for(int i = 0; i < 2 * sz; ++i)
            {
                ga.Set(i, 13*i);
                Assert.AreEqual(i < sz ? sz : 2 * sz, ga.LongLength);
            }
            for(int i = 0; i < 2 * sz; ++i)
            {
                Assert.AreEqual(i*13, ga.Get(i));
            }
        }
    }
}
