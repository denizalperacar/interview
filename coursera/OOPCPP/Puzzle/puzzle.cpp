#include "../Cube/Cube.h"
#include "../Tools/Utils.h"

uiuc::Cube *CreateUnitCube() {
    /* 
    Wrong use of variable pointer to created variable in stack.
    As a result it will be destroyed after return 
    statement i.e. deallocated.
    In some compilers it may sefault.
    */
    uiuc::Cube cube;
    cube.setLength(15);
    return &cube; // the address in the stack memory is returned! 
}

int main() {
    uiuc::Cube *c = CreateUnitCube();
    double a = c->getSurfaceArea();
    double v = c->getVolume();
    return 0;
}
