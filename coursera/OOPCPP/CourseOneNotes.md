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
delete c; c = nullptr;
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
int *c = new int; 
delete c; c = nullptr;

int *d = new int[3];
delete[] d;
```

### Arrow Operator (->)

```Cpp
Cube *c1 = new Cube;
c1->getVolume();
// it is equivalent to
(*c1).getVolume();
```

## Reference Variables

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

#### Custom default constructor

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

### Custom non-default constructors

```Cpp
// no return 
Cube::Cube(double length) {
    length_ = length;
}

```

### Copy constructors

A copy constructor allows us to create a copy of an existing object.

- there is a default copy constructor.

One can create custom copy constructors.

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

- needs the operator overloading. If a class is constructed it can not be constructed again. In order to change its value the assignment operator is used.

- There is a default assignment operator

A costum assignment operatormust be:

- a public member function of the class
- has function name operator=
- has a return value of the reference of the class
- has exactly one argument which is the const ref of the class type

Its example is presented below:

```Cpp
Cube & Cube::operator=(const Cube &obj){
    length_ = obj.length_;
    return *this;
}
```

### Variable Storage

Any variable can be stored:

- directly in memory `Cube c;` -> the default storage
- accessed by a pointer `Cube *d;` -> points to the allocated space
- accessed by reference `Cube &d = c`

#### Storage by reference

- A reference is an alias to the existing memory
- A reference does not store the memory itself, it is only an alias to the memory.
- the memory needs to be initialized.
- It is used to not create an copy.

#### pass by reference

Arguments can be passed to the function in three ways:

- Pass by value (default) -> creates a copy
- Pass by pointer (modified by `*`) -> creates a new pointer
- Pass by reference (modified by `&`) -> No copy is made the alias is sent.

```Cpp
bool sendCubeRef(Cube &c) {
    ...
}

bool sendCubePointer(Cube * c) {
    ...
}

int main() {
    Cube c(10);
    sendCubeRef(c); // does not create a copy
    sendCubePointer(&c); // No new cube is created.
}
```

#### Return by reference

- Return by value - a copy is created
- Return by pointer.
- Return by refernce. Do return if the object is created in the heap.
- Do not return by reference a memory create in stack

### Class Destructors

- There is an automatic default destructor.
- Automatic default constructers are always called when the object is reclaimed by the syste.
- automatic calls to the destructor in appropriate places where `stack objects should be destroyed` as they go out of scope, or where `heap objects are destroyed` with `"delete"`.

#### Custom destructors

- Need to be a member function
- it is the name of the class preceeded by `~`
- all destructors have no argurements and no return types.

```Cpp
Cube::~Cube(); // Custom destructor
```

## C++ Syntax Notes

### Segmentation fault (Segfault)

On Linux, if you dereference an address that you shouldn't, this is often called "segmentation fault," or "segfault." For example, if you dereference a pointer that is set to nullptr, it will almost certainly cause a segfault and crash immediately.

### Initialization

Remember that if you don't initialize a pointer, you really should not try to dereference it. If you dereference an uninitialized pointer, even just to read from it and not to write to it, you may cause your program to crash, or something else unexpected might happen later.

```Cpp
// Dangerous; this can lead to careless mistakes and crashes!
int* x;

// Explicitly initializing a pointer to nullptr
int* y = nullptr;
```

You can also initialize a value with the () syntax following the variable name.

```Cpp
// Other ways to initialize
int* y2(nullptr);
int* y3{nullptr};


```

Plain built-in types, such as int, that are not initialized will have unknown values. However, if you have a class type, its default constructor will be used to initialize the object.

be wary when you use "new" for a built-in type like int, since these types may not have default initialization.

```Cpp
int* r = new int(0);
```

### Resetting deleted pointers to nullptr

Note that using "delete" on a pointer frees the heap memory allocated at that address. However, deleting the pointer does not change the pointer value itself to "nullptr" automatically; you should do that yourself after using "delete", as a safety precaution.

```Cpp
// Allocate an integer on the heap:
int* x = new int;
// Now x holds some memory address to a valid integer.
// Do some kind of work with the integer.
// We'll just set that integer to 7:
*x = 7;
// Now delete the pointer to deallocate the heap memory:
delete x;
// This destroys the integer on the heap and frees the memory.
// But now x still holds the memory address!
// Set x to nullptr for safety:
x = nullptr;
```

- We don't want to delete the same allocated address more than once by mistake, which could cause errors. Using "delete" on nullptr does nothing, so this way, if we accidentally try to delete the same address twice, nothing further happens.

- We must never dereference a pointer to deallocated memory. attempting to dereference a nullptr will almost always cause a segfault and terminate the program immediately. This is actually better than causing a silent security vulnerabilty or another problem that is harder to detect!

### range based for loops

`for ( temporary variable declaration : container ) { loop body }`

```Cpp
for (auto i: vec) {...} // creates a copy
for (auto &i: vec) {...} // uses the alias and elements might be modified
for (cosnt auto &i:vec) {...} // uses alias but makes it read only
```

### unsigned integers

- Do not mix signed and unsigned integers in your code.
- the underlying bit representation that unsigned integers use for these very large values is actually the same as the representation that signed integers use for their negative value range. This means that a negative signed int may be re-interpreted as a very large positive unsigned int, and vice versa.
- The `size of containers` generally are `unsigned integers`.

```Cpp
// Casting to signed int first helps to ensure that the result
// of subtraction will truly be a signed negative value when size is 0:
for (int i=0; i <= (int)v.size()-1; i++) {
    // ...
}
```

## Week 4

## Template Types

A template type is a specialized type in C++ that can take on different types when the type is initialized.

```Cpp
#include <vector>
std::vector<uiuc::Cube> c;
```

### std::vector API

```Cpp
#include <vector> // defined in 
std::vector<T> // initialization
::push_back(T) // add to the back of the vector
::operator[](unsigned pos); // access specific position
::size(); // number of elements
```

### Template functions

```Cpp
template <typename T>
class List {
    ...
    private:
        T data_;
};

template <typename T>
int max(T a, T b) {
    if (a > b) { return a; }
    return b; 
}
```

- The errors are found in compile time

### Inheritence

- Inheritence allows us to inherit all the member functions and data from the base class to the derived class.
- shape class -> Cube class

lets define a class Shape:

```Cpp
#pragma once

// Base class in Shape.h
class Shape {
    public:
        Shape();
        Shape(double width);
        double getWidth() const; // equivalent to double getWidth(const Shape * this);

    private:
        double width_;
};

// derived class in Cube.h
#pragma once

#include "SHape.h"
#include "HSLAPixel.h"

namespace uiuc {
    class Cube : public Shape {
        public:
            Cube(double width, uiuc::HSLAPixel color);
            double getVolume() const;
        
        private:
            uiuc::HSLAPixel color_;
    };
}

// Cube.cpp

#include "Cube.h"
#include "Shape.h"

namespace uiuc {
    Cube::Cube(double width, uiuc::HSLAPixel coloe) : Shape(width) {
        color_ = color;
    }

    double Cube::getVolume() const {
        // this cannot access the Shape::width_ due to its being private
        // instead one must use Shape::getWidth() which is a public function.

        return getWidth() * getWidth() * getWidth();
    }
}
```

- `class Cube : public Shape {};` == `class Cube inherits from public class Shape {}`

#### Initialization of Inheritance

- When derived class is initialized, the derived class must construct the base class.
- Cube must construct Shape
- By default uses default constructor.
- Custom constructor can be used with an initialization list.

- `Cube::Cube(double width, uiuc::HSLAPixel coloe) : Shape(width)` intializes shape bu initialization list.

#### Access Control

When a base class is inherited, the derived class:

- can access all `public memebers` of the base class.
- Can `not` access the `private members` of the the base class.

#### Initializer List

It can be used to do the following:

- Initialize the base class.
- initialize the current class using another constructor.
- initialize the default values of the member variables.

```Cpp
    Shape::Shape() : Shape(1) {}; // It uses the next constructor to initialize
    Shape::Shape(double width) : width_(width) {};
    double Shape::getWidth() const { return width_; };
```
