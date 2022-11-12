#include "Cube.h"
#include "../Tools/Utils.h"

namespace uiuc {

    // Custom default constructor
    Cube::Cube() {
        length_ = 1;
    }

    // Custom constructor
    Cube::Cube(double length) {
        length_ = length;
    }

    // custom copy constructor
    Cube::Cube(const Cube &obj){
        length_ = obj.length_;
    }

    Cube & Cube::operator= (const Cube & obj) {
        length_ = obj.length_;
        return *this;
    }

    Cube::~Cube(){
        user::print("Cube destroyed");
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