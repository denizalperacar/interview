#ifndef GRID_H
#define GRID_H

#include <string>
#include <vector>
#include <cstdlib>

#include "life.h"
#include "cell.h"

class grid {
  private: 
    cell* cells[NUMROW+2][NUMCOL+2];
  
};

#endif /* GRID_H */
