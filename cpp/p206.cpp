
#include <iostream>
#include <sstream>
#include <cmath>

using namespace::std;

bool matches(long sq) {
  long mod  = 10;
  bool result = true;
  long i = 10;
  while (result && i >= 0) {
    long check = i % 10;
    long expect = (sq % mod);
    result &= (expect == check);
    sq /= 100;
    i--;
  }
  return result;
}


int main() {
  long x = sqrt(1020304050607080900); 
  do {
    long sqx = x*x;
    if(matches(sqx)) {
      cout << "x: " << x << ", square: " << sqx << ", matches: " << matches(sqx)  <<endl;
      break;
    }
    x++;
  } while(true);
}
