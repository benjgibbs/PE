#include <iostream>
#include <set>
#include <algorithm>
#include <iterator>

#include <boost/timer.hpp>

#include "sieve.h"

using namespace std;

set<long> divisors(long of) {
  set<long> result;
  for (long i = 1; i <= of; i++) {
    if ( of % i == 0 ) {
      result.insert(i);
    }
  }
  return result;
}

void printDivisors(long of, set<long> divs) {
  cout << "Divisors of " << of << ": ";
  ostream_iterator<long> it(cout, ", ");
  copy(divs.begin(), divs.end(), it);
  cout << endl;
}

bool check(const Sieve& sieve, long toCheck) {
  set<long> divs = divisors(toCheck);
  //printDivisors(toCheck, divs);
  for (set<long>::const_iterator d =  divs.begin(); d != divs.end(); d++) {
    long x = *d + toCheck / *d;
    if ( ! sieve.isPrime(x)) {
      return false;
    }
  }
  return true;
}

int main() {
  //long upto = 100000000;
  long upto = 100000;
  cout << "Building sieve..." << endl;
  Sieve sieve(upto+1);
  cout << "... done" << endl;
  long sum = 0;
  boost::timer resetTimer, durationTimer;
  int slice = 10000;
  for (long i = 1; i <= upto; i++) {
    if( i % slice == 0) {
      long remain = upto - i;
      double togo1 =  resetTimer.elapsed() * (remain/slice) / 60;
      double togo2 =  ((durationTimer.elapsed()/i) * remain) / 60;
      cout << i  << "(" << resetTimer.elapsed() << "/" << togo1 
                  << "|" <<  durationTimer.elapsed() << "/" << togo2 << "), " << endl;
      resetTimer.restart();
    }
    if (check(sieve, i)) {
      sum += i;
    }
  }
  std::cout << "\nSum is: " << sum << endl;
}

