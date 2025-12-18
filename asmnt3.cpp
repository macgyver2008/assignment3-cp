// 헤더 넣기 까먹음

#include <iostream>


double factorial(const double fact_num) {
  if (fact_num <= 0) {
    std::cout << "wrong number for factorial\n";
    return 0;
  }

  if (fact_num == 1) {
    return 1;
  }

  return fact_num * factorial(fact_num - 1);
}

double catalan_calculate(const double catal_num, const int repeats) {
  if (repeats <= 0) {
    return 0;
  }

  const double answer =
      factorial(2 * catal_num) /
      factorial(catal_num + 1) /
      factorial(catal_num);

  std::cout << catal_num << "'s number: " << answer << '\n';

  if (repeats == 1) {
    std::cout << "The " << catal_num
              << "'s number in Catalan number: "
              << answer << '\n';
  }

  return catalan_calculate(catal_num + 1, repeats - 1);
}

int main() {
  int repeats;
  std::cin >> repeats;

  if (repeats <= 0) {
    std::cout << "Input positive number please\n";
    return 1;
  }

  catalan_calculate(1, repeats);
  return 0;
}
