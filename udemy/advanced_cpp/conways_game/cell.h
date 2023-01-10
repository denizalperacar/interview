#ifndef CELL_H
#define CELL_H

#include "life.h"

class cell {
  private: 
    bool alive_;
  public:
    cell() : alive_(false) {}
    void draw(int row, int col) const; 
    void create() { alive_ = true; }
    void erase() {alive_ = false; }
    bool is_alive() {return alive_; }

};

#endif /* CELL_H */
