#ifndef LIFE_H
#define LIFE_H

const char live_cell{'X'};
const char dead_cell{' '};

// occupies rows from 1 to 23
// occupies columns from 1 to 79
const int NUMROW {23};
const int NUMCOL {79};

// conwey's parameters
const int min_neighbours {2};
const int max_neighbours {3};
const int min_parents {3};
const int max_parents {3};

#endif /* LIFE_H */
