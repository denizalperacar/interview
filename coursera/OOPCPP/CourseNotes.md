# Course Notes

## Coding Style

**Private memebers:** add `_` after their names `length_`.

## week 1

### Encapsulation

Encloses the data and its functionlaity into one single unit.
See cube.h, cube.cpp

#### Public vs Private Data

Determines the access clinet code has to the data.
The `Public` members can be accessed by the client. Whereas the `Private` members can only be accessed by the class itself.

#### Header file vs Implementation file

- Header `.h` files determine the interface to the class defined independently from the implementation `.cpp` file.

#### Header file

- Declaration of all memeber and memeber functions. It is similar to an API.
- `#pragma once` : define the class only once.
- `class M {};` : dont forget the `;` at the end of the class declaration.

#### CPP file

- Include the refernce to its header file in the beginning.
- The namespace of the class is required in the CPP file :`double Cube::getVolume()`.

### std library

All of these functions are under the namespace `std`.

```Cpp
#include <iostream>
std::cout << // consol out
std::endl // new line and flush the stream
std::cin >> varaible; // standard input from the terminal
```

### Namespaces

Add the namespace directive in both `.cpp` and `.h` files.

```Cpp
// in .h file
namespace uiuc {
    class Cube {
        public:
            double getVolume();
    };
}

// in .cpp file
namespace uiuc {
    double Cube::getVolume() {
        return ...;
    }
}
```

## Week 2

## Stack memory Notes

It is the default memory loc in C++.
Every variable has a name, type, value and a location in memory
`int prime = 7;` use `&` operator to return the addressof the variable.
the address of this varibale will be a large number as it is stored in the stack memory.

- Any function would have a stack memory that upon ending its lifesycle will be released.
- SM starts from high addresses and goes down.
- It is released automatically.

### Pointers

A variable that stores the address of the variable. It is a level of indirection from the data.

`int * p = &num;` note that here the address is stored.

The level of indirection is removed by dereferencing; `*p = 42;`.

So what will be the p in the following example:

```C++
int num = 7; // variable is 7
int * p = &num; // p is the address of num
int value_in_num = *p; // the value that p is holding is copied to value_in_num
*p = 42; // num becomes 42
```

## Heap Memory Notes

This memory exists for more than the lifecycle of the function. 

- Use `new` operator to allocate a memory in heap. This keyword return the pointer to the starting address of the data rather than the value.
- This memory needs to be destoryed by `delete` operator.
- Heap memory starts at smaller addresses then grows up.

### `new`

- Allocate memory on the heap
- initialize the datastructure
- Return a pointer to the start of the data structure

```Cpp
int * numPtr = new int;
```

- the `numPtr` is a pointer that is stored in the stack
- The `numptr` refers to a int declared in the heap.

```Cpp
int * numPtr = new int;
// what are the following:
*numPtr; // what ever was at the memory
numPtr; // address of the pointer in the heap
&numPtr; // address of the variable in the stack
*numPtr = 42; // new value of the numPtr referenced location in heap
*numPtr; // 42
numPtr; // same as before i.e. heap address
&numPtr; // same as before i.e. stack address
```

### `delete`

- The lifecycle of the heap variable only ends when its deleted.
- Remember that after the line "delete c;" the pointer c still stores the address of the deleted variable, which is no longer valid to dereference and is therefore dangerous. The pointer won't be automatically set to nullptr. Then, you should manually set c to nullptr if you want to better protect against coding mistakes:

```Cpp
int *c = new int; 
delete c; c = nullptr;

int *d = new int[3];
delete[] d;
```

### Arrow Operator ->

```Cpp
Cube *c1 = new Cube;
c1->getVolume();
// it is equivalent to
(*c1).getVolume();
```

## Reference Variable

It will alais a piece of memory to give it a name.

```Cpp
int *x = new int;
int &v = *x;
```

## Week 3

Notes on the class creation are provided here:

### Class constructors

There is an automatic default constructor. It initializes all the member variables to their default values.

- There may be more than one constructor definitions in the class.
- If any constructor is defined the automatic default constructor will not be provided anymore.

#### Costum default constructor

- It overrides the ADC.
- There are no arguments provided for this constructor.
- It does not return anything to the user.

```Cpp
public:
    Cube(); // Custom default constructor. 

namespace uiuc {
    Cube::Cube() {
        length_ = 1;
    }
}

```

### Costum non-default constructors

```Cpp
// no return 
Cube::Cube(double length) {
    length_ = length;
}

```

### Copy constructors

A copy constructor allows us to create a copy of an existing object.

- there is a default copy constructor.

One can create costum copy constructors.

- These constructors only have one argumet which is a `const` refernce to the same type object.

```Cpp
Cube::Cube(const Cube & obj);
```

- Copy constructors are involed automatically then the object is passed as a parameter (pass by value) or returning an object from a function (pass by value) or initializing a new object.
- The default constructor works when an object is constructed, so if the obejct is constructed already and the copy is done, the copy constructor will not be invoked:

```Cpp
int main() {
    Cube c; // DC
    Cube d; // DC
    c = d; // no constructor is invoked.
}
```

### Copy Assignment

### Variable Storage

### Class Destructors

