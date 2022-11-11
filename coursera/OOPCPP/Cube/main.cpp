#include "Cube.h"
#include <iostream>
#include "../Tools/Utils.h"

int main() {

    uiuc::Cube c;
    c.setLength(3.48);
    double volume = c.getVolume();
    user::print(volume);
    return 0;
    
}

