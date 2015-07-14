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

  for (long d = 1; d <= toCheck/2; d++) {
    if ( toCheck % d == 0 ) {
      // is divisor
      long x = d + toCheck / d;
      if ( ! sieve.isPrime(x)) {
        return false;
      }
    }
  }
  return true;
}

void runSolve() {
  long upto = 100000000;
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
      cout << i  << ": " << setprecision(3) << resetTimer.elapsed() << "/" << togo1 
           << "|" << setprecision(3) << durationTimer.elapsed() << "/" << togo2 << endl;
      resetTimer.restart();
    }
    if (check(sieve, i)) {
      sum += i;
    }
  }
  std::cout << "\nSum is: " << sum << endl;
}


int main() {
  runSolve();
/*
  long upto = 100;
  Sieve sieve(upto);
  for(int i = 1; i < upto; i++) {
    cout << i << ": " << check(sieve, i) << endl;
  }
  */
}

