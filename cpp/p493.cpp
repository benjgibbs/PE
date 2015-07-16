
#include <iostream>
#include <iomanip>

using namespace std;

double fact(double x) {
  double acc = 1.0;
  while(x > 1) {
    acc *= x;
    x--;
  }
  return acc;
}

double nCk(double n, double k) {
  return fact(n) / (fact(k) * fact(n-k));
}

int main(int argc, char** argv) {
  cout << setprecision(10) << 7 * (1 - nCk(60,20)/nCk(70,20))   << endl;
}
