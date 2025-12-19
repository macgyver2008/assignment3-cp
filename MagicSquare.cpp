#include <iostream>

namespace {
const int kSize = 9;
const int kMagicSum = 15;

int square[kSize];
bool used[kSize + 1];
}  // namespace

void FillSquare(int position);
bool IsMagicSquare();
void PrintSquare();

int main() {
  FillSquare(0);
  return 0;
}

/*
 * Recursively fills the square using backtracking.
 */
void FillSquare(int position) {
  if (position == kSize) {
    if (IsMagicSquare()) {
      PrintSquare();
    }
    return;
  }

  for (int number = 1; number <= kSize; number++) {
    if (!used[number]) {
      square[position] = number;
      used[number] = true;

      FillSquare(position + 1);

      used[number] = false;
    }
  }
}

/*
 * Checks whether the current square satisfies magic square conditions.
 */
bool IsMagicSquare() {
  // Rows
  if (square[0] + square[1] + square[2] != kMagicSum) return false;
  if (square[3] + square[4] + square[5] != kMagicSum) return false;
  if (square[6] + square[7] + square[8] != kMagicSum) return false;

  // Columns
  if (square[0] + square[3] + square[6] != kMagicSum) return false;
  if (square[1] + square[4] + square[7] != kMagicSum) return false;
  if (square[2] + square[5] + square[8] != kMagicSum) return false;

  // Diagonals
  if (square[0] + square[4] + square[8] != kMagicSum) return false;
  if (square[2] + square[4] + square[6] != kMagicSum) return false;

  return true;
}

/*
 * Prints the magic square in a 3x3 format.
 */
void PrintSquare() {
  std::cout << "Magic Square:\n";
  for (int i = 0; i < kSize; i++) {
    std::cout << square[i] << " ";
    if (i % 3 == 2) {
      std::cout << "\n";
    }
  }
  std::cout << "\n";
}
