
#include <iostream>
#include "LinkedList.h"

int main () {

    LinkedList<int> l;
    
    for (int i=0; i<10; i++) {
        l.push_front(i * 2);
        std::cout << l << std::endl;
    }

    return 0;
}