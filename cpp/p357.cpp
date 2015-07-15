#include <iostream>
#include <set>
#include <algorithm>
#include <iterator>
#include <iomanip>

#include <boost/timer.hpp>

#include "sieve.h"

using namespace std;

bool check(const Sieve& sieve, long toCheck) {
  if (toCheck > 1 && toCheck % 2 == 1) return false;
  if (!sieve.isPrime(toCheck + 1)) return false;
  
  for (long d = 1; d*d <= toCheck; d++) {
    if (toCheck % d == 0) {
      long x = d + toCheck / d;
      if (!sieve.isPrime(x)) {
        return false;
      }
    }
  }
  return true;
}

int main() {
  long N = 100000000;
  cout << "Building sieve..." << endl;
  boost::timer st;
  Sieve sieve(N+1);
  cout << "... done (" << st.elapsed() << ")" << endl;
 
  long sum = 0;
  
  boost::timer t;
  for (long i = 1; i <= N; i++) {
    if (check(sieve, i)) {
      sum += i;
    }
  }
  cout << "Sum is: " << sum  
       << " (" << st.elapsed() << "/" << t.elapsed() << ")" << endl;
}

