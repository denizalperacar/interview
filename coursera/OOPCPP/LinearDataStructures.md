# Linear Data Structures

Overview of the contents

- arrays
- Linked memory
- array and list operations
- Queue
- Stack

## Arrays

An array stores the data in blocks of sequential memory.

```Cpp
int arr[3] = {1,2,3};
```

- Array elements are accessed by `[]`

### Array limitations

- All the elements must of the same type.
- The size of the type of the data is known (the number of bytes).
- one can use the `sizeof(Cube)` to find the number of bytes of an object.
- An array has a fixed capacity.

### std::vector<>

It implements a dynamic array.

- Array elements are of fixed type.
- At a given point the array hasa fixed capacity.
- The array is expanded when the capacity is reached.
