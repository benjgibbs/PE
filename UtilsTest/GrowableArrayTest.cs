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
            for(int i = 0; i < sz; ++i)
            {
                ga.Set(i, 13*i);
            }
            for(int i = 0; i < sz; ++i)
            {
                Assert.AreEqual(i*13, ga.Get(i));
                Assert.AreEqual(sz, ga.LongLength);
            }
        }
    }
}
