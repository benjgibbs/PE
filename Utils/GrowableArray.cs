using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils
{
    public class GrowableArray<T>
    {
        List<T[]> chunks = new List<T[]>();
        private long chunkSz;

        public GrowableArray(long initialSz)
        {
            this.chunkSz = initialSz;
        }

        public void AddChunk()
        {
            chunks.Add(new T[chunkSz]);
        }

        public void Set(long idx, T val)
        {
            while (LongLength < (idx+1))
            {
                AddChunk();
            }
            int chunk = (int)(idx / chunkSz);
            long chunkPos = idx % chunkSz;
            chunks[chunk][chunkPos] = val;
        }

        public T Get(long idx)
        {
            BoundsCheck(idx);
            int chunk = (int)(idx / chunkSz);
            long chunkPos = idx % chunkSz;
            return chunks[chunk][chunkPos];
        }

        private void BoundsCheck(long idx)
        {
            if (idx > LongLength)
                throw new InvalidOperationException("Can't fetch past end of array");
        }

        public long LongLength
        {
            get
            {
                return chunks.Count * chunkSz;
            }
        }

        private T[] LastChunk()
        {
            return chunks[chunks.Count - 1];
        }
    }
}
