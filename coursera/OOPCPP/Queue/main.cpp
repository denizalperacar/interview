#include <iostream>
#include "Queue.h"

int main() {

    Queue<int> q;
    
    for (int i = 0; i <= 15; i++) {
        q.push_back(i * 2);
        std::cout << q << std::endl;
        if ((i % 2) == 0 && i != 0) {
            int data = q.pop_front();
            std::cout << data << std::endl;    
        }
    }
    return 0;
}