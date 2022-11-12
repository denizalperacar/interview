#include "Cube.h"

namespace uiuc {

    // Costum default constructor
    Cube::Cube() {
        length_ = 1;
    }

    // Costum constructor
    Cube::Cube(double length) {
        length_ = length;
    }

    // costum copy constructor
    Cube::Cube(const Cube &obj){
        length_ = obj.length_;
    }

    double Cube::getVolume() {
        return length_ * length_ * length_;
    }

    double Cube::getSurfaceArea() {
        return 6 * length_ * length_;
    }

    void Cube::setLength(double length) {
        length_ = length;
    }
}