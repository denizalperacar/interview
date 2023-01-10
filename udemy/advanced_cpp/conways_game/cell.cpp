#include <iostream>
#include "cell.h"

void cell::draw(int row, int col) const {
  // escape \x1b[n;mH moves the cursor to the row n and col m
  // it is one based so the first row starts at 1.
  std::cout << "\xb1[" << row + 1 << ";" << col + 1 << "H";
  std::cout << (alive_ ? live_cell : dead_cell);
}
