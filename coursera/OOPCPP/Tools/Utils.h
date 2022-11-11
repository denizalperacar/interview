#pragma once
#include <iostream>
#include <vector>

namespace user {
    template <typename T> 
    void print(T value) {
        std::cout << value << std::endl;
    }

    template <typename T> 
    void print(std::vector<T> value) {
        for (auto i: value) {
            std::cout << i << " ";
        }
        std::cout << std::endl;
    }
}